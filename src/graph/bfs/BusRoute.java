package graph.bfs;

import java.util.*;
import java.util.stream.IntStream;

public class BusRoute {
    public static void main(String[] args) {
        int ans = new BusRoute().numBusesToDestination(new int[][]{{1,9,12,20,23,24,35,38},{10,21,24,31,32,34,37,38,43},{10,19,28,37},{8},{14,19},{11,17,23,31,41,43,44},{21,26,29,33},{5,11,33,41},{4,5,8,9,24,44}}, 37, 28);
        System.out.println(ans);
    }
    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, Set<Integer>> stationToRoutes = new HashMap();
        Map<Integer, List<Integer>> adj = new HashMap();
        for(int i = 0; i< routes.length; i++) {
            for(int j = 0; j< routes[i].length; j++) {
                stationToRoutes.putIfAbsent(routes[i][j], new HashSet());
                stationToRoutes.get(routes[i][j]).add(i);
            }
        }
        for(int i = 0; i< routes.length; i++) {
            for(int j = i+1; j< routes.length; j++) {
                adj.putIfAbsent(i, new LinkedList());
                adj.putIfAbsent(j, new LinkedList());
                if(ifConnected(routes, i, j)) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        Queue<Integer> q = new LinkedList();
        int ans = 0;
        boolean found = false;
        boolean[] visited = new boolean[routes.length];
        for(Integer route: stationToRoutes.get(source)) {
            q.add(route);
            visited[route] = true;
        }
        adj.forEach((k, v) -> System.out.print(k + " " + v + "\n"));

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i<size; i++) {
                Integer currentRoute = q.poll();
                if(routeContainsStop(routes[currentRoute], target)) {
                    found = true;
                    break;
                }
                for(int route: adj.get(currentRoute)) {
                    if(!visited[route]) {
                        visited[route] = true;
                        q.add(route);
                    }
                }
            }
            ans++;
        }
        return found? ans: -1;
    }
    private boolean ifConnected(int[][] routes, int p, int q) {
        for(int i = 0; i< routes[p].length; i++) {
            for(int j = 0; j< routes[q].length; j++) {
                if(routes[p][i] == routes[q][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean routeContainsStop(int[] arr, int currentRoute) {
        for(int a: arr) {
            if(a == currentRoute) {
                return true;
            }
        }
        return false;
    }
    private List<Integer> getInitialRoute(int[][] routes, int source) {
        List<Integer> res = new LinkedList();
        for(int i = 0; i <routes.length; i++) {
            if(IntStream.of(routes[i]).anyMatch(a -> a == source))
                res.add(i);
        }
        return res;
    }
}
