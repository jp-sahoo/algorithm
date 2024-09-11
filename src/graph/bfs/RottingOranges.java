package graph.bfs;

import java.util.*;

/**
 * https://leetcode.com/problems/rotting-oranges/
 * do bfs to calculate every steps a rotten orange will make rotten other oranges surrounding it
 * step-1 : calculate number of fresh oranges and add all rotten oranges to the queue and start bfs
 * move in all 4 direction
 * when all of current rotten oranges in the queue are processed, increase step by 1
 * while you add the fresh oranges, calculate them if they are covered to match later
 */
public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        Queue<Integer[]> queue = new LinkedList<>();
        int total = 0;
        for(int i = 0; i< grid.length; i++) {
            for(int j = 0; j< grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    total++;
                }
                if(grid[i][j] == 2){
                    queue.add(new Integer[]{i, j});
                }
            }
        }
        int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int current = 0;
        int step = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Integer[] cur = queue.poll();
                for(int j = 0; j<4; j++) {
                    int newI = cur[0] + direction[j][0];
                    int newJ = cur[1] + direction[j][1];
                    if(newI>=0 && newI < grid.length && newJ>=0 && newJ < grid[0].length && grid[newI][newJ] == 1) {
                        queue.add(new Integer[]{newI, newJ});
                        grid[newI][newJ] = 2;
                        current++;
                    }
                }
            }
            step++;
        }
        System.out.println(total + " " + current + " " + step);
        if(total == 0) {
            return 0;
        } else if(total == current) {
            return step - 1;
        } else {
            return -1;
        }
    }
}
