package graph.bfs;

import com.sun.org.apache.xpath.internal.operations.String;
import java.util.Arrays;
import java.util.stream.Collectors;

public class NumberOfIsland {
    public static void main(String[] args) {
        char[][] data = {{'1', '1', '1'},{'0', '1', '0'}, {'1', '1', '1'}};
//        int result = new graph.bfs.NumberOfIsland().numIslands(data);
//        Arrays.fill(data, '.');
//        List<java.lang.String> ok = Arrays.stream(data).map(java.lang.String::new).collect(Collectors.toList());
        Arrays.stream(data).map(java.lang.String::new).collect(Collectors.toList());
//        System.out.println(result);
        System.out.println(Arrays.deepToString(data));
    }
    public int hammingWeight(int n) {
        int count = 0;
        for(int i = 0; i<n/2;i++) {
            if((n & (1<<i)) != 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * maintain visited metrics
     * start bfs and mark the node visited
     * count the number of bfs possible
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i = 0; i< grid.length; i++) {
            for(int j = 0; j< grid[0].length; j++) {
                if(isValid(grid, i, j, vis)) {
                    vis[i][j] = true;
                    System.out.println(i + " " + j);
                    bfs(grid, i, j, vis);
                    System.out.println(i + " ==== " + j);
                    for(boolean[] a: vis) {
                        for(boolean b: a) {
                            System.out.print(b + ", ");
                        }
                        System.out.println();
                    }
                    count++;
                }
            }
        }
        return count;
    }

    void bfs(char[][] grid, int p, int q, boolean[][] vis) {
        System.out.println(p + " ##new BFS " + q);
        int[] x = {0, -1, 1, 0};
        int[] y = {-1, 0, 0, 1};
        for(int i = 0; i< x.length; i++) {
            int newI = p + x[i], newJ = q + y[i];
            System.out.println(newI + " ##before validation## " + newJ);
            if(isValid(grid, newI, newJ, vis)) {
                System.out.println(newI + " ##valid## " + newJ);
                vis[newI][newJ] = true;
                bfs(grid, newI, newJ, vis);
            }
        }
    }

    private boolean isValid(char[][] grid, int p, int q, boolean[][] vis) {
        return p >= 0 && p < vis.length && q >=0 && q< vis[0].length && !vis[p][q] && grid[p][q] == '1';
    }
}