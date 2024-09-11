package graph.bfs;

import java.util.*;

/**
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/description/
 */
public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {

    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<Integer[]> queue = new LinkedList<>();
        if(grid[0][0] == 0) {
            queue.add(new Integer[]{0, 0});
            grid[0][0] = 1;
            if(grid.length == 1 && grid[0].length == 1) return grid[0][0];
        } else {
            return -1;
        }
        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
        while(!queue.isEmpty()) {
            Integer[] cur = queue.poll();
            for(int i = 0; i< 8; i++) {
                int newI = cur[0] + dir[i][0];
                int newJ = cur[1] + dir[i][1];
                if(newI >= 0 && newI < grid.length && newJ >= 0 && newJ < grid[0].length && grid[newI][newJ] == 0) {
                    queue.add(new Integer[]{newI, newJ});
                    grid[newI][newJ] = grid[cur[0]][cur[1]] + 1;
                }
            }
        }
        return grid[grid.length -1][grid[0].length -1] <= 1? -1 : grid[grid.length -1][grid[0].length -1];
    }
}
