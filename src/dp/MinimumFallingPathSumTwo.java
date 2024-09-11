package dp;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-falling-path-sum-ii/
 * start from bottom, maintain 
 */
public class MinimumFallingPathSumTwo {
    public int minFallingPathSum(int[][] grid) {
        int[][] res = new int[grid.length][grid[0].length];
        int prevMin = Integer.MAX_VALUE, prevMinIndex = 0, prevSecondMin = Integer.MAX_VALUE;
        for(int i = 0; i < grid.length; i++) {
            res[grid.length-1][i] = grid[grid.length-1][i];
            if(prevMin > grid[grid.length-1][i]) {
                prevMin = grid[grid.length-1][i];
                prevMinIndex = i;
            }
            if(grid[grid.length-1][i] > prevMin) {
                prevSecondMin = Math.min(prevSecondMin, grid[grid.length-1][i]);
            }
        }
        int curMin = Integer.MAX_VALUE, curMinIndex = 0, curSecondMin = Integer.MAX_VALUE;
        for(int i = grid.length-2; i >=0; i--) {
            System.out.println(prevMin + " " + prevSecondMin + " " + prevMinIndex);
            for(int j = 0; j < grid[0].length; j++) {
                res[i][j] = (j == prevMinIndex ? prevSecondMin : prevMin) + grid[i][j];
                if(curMin > res[i][j]) {
                    curMin = res[i][j];
                    curMinIndex = j;
                }
                if(res[i][j] > curMin) {
                    curSecondMin = Math.min(curSecondMin, res[i][j]);
                }
            }
            prevMin = curMin;
            prevSecondMin = curSecondMin;
            prevMinIndex = curMinIndex;
        }
        int ans = Integer.MAX_VALUE;
        System.out.println(Arrays.deepToString(res));
        for(int k = 0; k<grid[0].length; k++) {
            ans = Math.min(ans, res[0][k]);
        }
        return ans;
    }

    int getMin(int[][]res, int i, int j) {
        int min = Integer.MAX_VALUE;
        for(int k = 0; k<res[0].length; k++) {
            if(k != j)
                min = Math.min(min, res[i][k]);
        }
        return min;
    }
}
