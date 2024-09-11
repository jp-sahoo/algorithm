package dp;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/russian-doll-envelopes/description/
 * hard
 */
public class MaximumRussianDollEnvelopes {
    public static void main(String[] args) {
        int res = new MaximumRussianDollEnvelopes().maxEnvelopes(new int[][]{{10, 8},{1, 12},{6, 15},{2, 18}});
        System.out.println(res);
    }
    public int maxEnvelopes(int[][] envelopes) {
        int[] res = new int[envelopes.length];
        Arrays.fill(res, 1);
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        System.out.println(Arrays.deepToString(envelopes));
        for(int i=1; i<envelopes.length; i++) {
            for(int j=0; j < i; j++) {
                if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1] && res[i] < res[j] + 1) {
                    res[i] = res[j] + 1;
                }
            }
        }
        return res[res.length -1];
    }
}
