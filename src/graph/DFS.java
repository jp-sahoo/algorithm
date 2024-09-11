package graph;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    public static void main(String[] args) {
//        List<List<Integer>> ans = new graph.DFS().allPathsSourceTarget(new int[][]{{1, 3, 4}, {2, 3, 4}, {3}, {4}, {}});

        List<List<Integer>> ans = new DFS().allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}});
        ans.forEach(a -> {
            a.forEach(System.out::print);
            System.out.println();
        });
    }

    public static void path(ArrayList<Edge>[] graph, int src, int dest, List<Integer> currentPath, List<List<Integer>> result) {
        currentPath.add(src);

        if (src == dest) {
            result.add(new ArrayList<>(currentPath));
        } else {
            for (Edge e : graph[src]) {
                path(graph, e.dest, dest, currentPath, result);
            }
        }

        // Backtrack by removing the last node from the currentPath
        currentPath.remove(currentPath.size() - 1);
    }

    public static ArrayList<Edge>[] create(int[][] graph, int n) {
        ArrayList<Edge>[] grapho = new ArrayList[n];
        for (int i = 0; i < graph.length; i++) {
            grapho[i] = new ArrayList<>();
        }
        for (int i = 0; i < graph.length; i++) {
            int src = i;
            for (int j = 0; j < graph[i].length; j++) {
                Edge e = new Edge(src, graph[i][j]);
                grapho[src].add(e);
            }
        }
        return grapho;
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        ArrayList<Edge>[] g = create(graph, n);
//        Arrays.stream(g).forEach(a-> System.out.println(Arrays.toString(a.toArray())));
        List<List<Integer>> result = new ArrayList<>();
//        return result;


        List<Integer> currentPath = new ArrayList<>();
        path(g, 0, n - 1, currentPath, result);

        return result;
    }

    public static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "src=" + src +
                    ", dest=" + dest +
                    '}';
        }
    }
}
