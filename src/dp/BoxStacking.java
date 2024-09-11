package dp;

import java.util.Arrays;
import java.util.Comparator;

public class BoxStacking {
    public static void main(String[] args) {

    }
    public int maxHeight(int[][] cuboids) {
        int[] ans = new int[cuboids.length];
        for(int[] a: cuboids) {
            Arrays.sort(a);
        }
        Arrays.sort(cuboids, Comparator.comparingInt(a-> a[0]));
        // System.out.println(Arrays.deepToString(cuboids));
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < cuboids.length; i++) {
            ans[i] = cuboids[i][2];
            max = Math.max(max, cuboids[i][2]);
        }
        for(int i = 1; i < cuboids.length; i++) {
            for(int j = 0; j < i; j++) {
                if(possible(cuboids, i, j)) {
                    if(ans[j] + cuboids[i][2] > ans[i]) {
                        ans[i] = ans[j] + cuboids[i][2];
                        max = Math.max(max, ans[i]);
                        // System.out.println("checking " + i + " "+ j + " " + Arrays.toString(ans));
                    }
                }
            }
        }
        // System.out.println(Arrays.toString(ans));
        return max;
    }

    private boolean possible(int[][] cuboids, int i, int j) {
        return cuboids[j][2] <= cuboids[i][2] && ((cuboids[j][0] <= cuboids[i][0] && cuboids[j][1] <= cuboids[i][1]) ||
                (cuboids[j][0] <= cuboids[i][1] && cuboids[j][1] <= cuboids[i][0]));
    }
}
