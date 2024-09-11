package graph;

import java.util.*;

public class Dijkstra {
    public static void main(String[] args) {
        int[][] adjMatrix = new int[5][5];//weight from i to j
        adjMatrix[0][1] = 4;
        adjMatrix[0][2] = 1;
        adjMatrix[2][3] = 4;
        adjMatrix[2][1] = 2;
        adjMatrix[3][4] = 4;
        adjMatrix[1][4] = 4;
        Graph g = new Graph(5, adjMatrix);
        int[] ans = new Dijkstra().disjkstra(g, 2);
        System.out.println(Arrays.toString(ans));
//        System.out.println(1<<2);
//        Collections.sor

    }

    int[] disjkstra(Graph g, int s) {
        int[][] finalIndToDist = new int[g.count][2];
        for (int i = 0; i < g.count; i++) {
            finalIndToDist[i][0] = i;
            finalIndToDist[i][1] = -1;
        }
        finalIndToDist[s][1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
//        PriorityQueue<Pair<Integer, Integer>> pq1 = new PriorityQueue<>(Comparator.comparing(Pair::getKey));
//        pq1.add(new Pair<>(1, 2));
        pq.add(finalIndToDist[s]);
        while (!pq.isEmpty()) {
            int fromIndex = pq.poll()[0];//ar has index and updated distance
            for (int toIndex = 0; toIndex < g.count; toIndex++) {
                int dist = g.adjMatrix[fromIndex][toIndex];
                if (fromIndex == toIndex || dist == 0) continue;
                if (finalIndToDist[toIndex][1] == -1 || finalIndToDist[fromIndex][1] + dist < finalIndToDist[toIndex][1]) {
                    if(finalIndToDist[toIndex][1] != -1) {
                        pq.remove(finalIndToDist[toIndex]);
                    }
                    finalIndToDist[toIndex][1] = finalIndToDist[fromIndex][1] + dist;
                    pq.add(finalIndToDist[toIndex]);
                }
            }
        }
        return Arrays.stream(finalIndToDist).mapToInt(a -> a[1]).toArray();
    }

    static class Graph {
        int count;
        int[][] adjMatrix;
        public Graph(int count, int[][] adjMatrix) {
            this.count = count;
            this.adjMatrix = adjMatrix;
        }
    }
}
