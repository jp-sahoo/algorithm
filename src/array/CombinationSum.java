package array;

import java.util.Arrays;

public class CombinationSum {
    public static void main(String[] args) {
        int ok = new CombinationSum().combinationSum4(new int[]{1, 2, 3}, 4);
        System.out.println(ok);
    }

    public int combinationSum4(int[] nums, int target) {
        int[] k = new int[target + 1];
        k[0] = 1;
        for (int num : nums) {
            for (int j = num; j <= target; j++) {
                k[j] += k[j - num];
            }
            System.out.println(Arrays.toString(k));
        }
        System.out.println(Arrays.toString(k));
        return k[target];
    }
}
