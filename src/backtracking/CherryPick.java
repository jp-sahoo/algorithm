package backtracking;

/**
 * https://leetcode.com/problems/cherry-pickup/
 * treat going down and going up from the bottom-right corner as a single traversal
 * Keep collecting cherry from the path you visit, and keep it back on backtracking
 * once you reach bottom-right corner, go up and left to reach top-left corner and when you reach there check with the maximum collected along the path
 */
public class CherryPick {
    static int max = 0;

    public static void main(String[] args) {
//        new CherryPick().TopToBottom(new int[][]{{0,1,1,0,0},{1,1,1,1,0},{-1,1,1,1,-1},{0,1,1,1,0},{1,0,-1,0,0}}, 0, 0, 0);
        new CherryPick().TopToBottom(new int[][]{{0, 1, -1}, {1, 0, -1}, {1, 1, 1}}, 0, 0, 0);
        System.out.println(max);
    }

    public void TopToBottom(int[][] grid, int i, int j, int totalCount) {
        if (i >= grid.length || j >= grid[0].length || grid[i][j] == -1) {
            return;
        }
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            bottomUp(grid, i, j, totalCount);
            return;
        }
        int temp = grid[i][j];
        grid[i][j] = 0;
        TopToBottom(grid, i + 1, j, totalCount + temp);
        TopToBottom(grid, i, j + 1, totalCount + temp);
        grid[i][j] = temp;
    }

    public void bottomUp(int[][] grid, int i, int j, int totalCount) {
        if (i < 0 || j < 0 || grid[i][j] == -1) {
            return;
        }
        if (i == 0 && j == 0) {
            totalCount += grid[i][j];
            max = Math.max(max, totalCount);
            return;
        }
        int temp = grid[i][j];
        grid[i][j] = 0;
        bottomUp(grid, i - 1, j, totalCount + temp);
        bottomUp(grid, i, j - 1, totalCount + temp);
        grid[i][j] = temp;
    }
}
