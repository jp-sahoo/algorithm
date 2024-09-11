package dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
//        int result = new dp.LongestIncreasingSubsequence().lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6});
//        System.out.println(result);
        System.out.println("cats".substring(1,2));
    }

    /**
     * to calculate LIS at any point, we need to have solved for all previous positions by using DP
     * now you check for all previous element, if the element is less than the current element
     * and if we are getting a better solution -> solution at previous element + 1 > solution at current position, update if yes
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i] && res[i] < res[j] + 1) {
                    res[i] = res[j] + 1;
                }
            }
            System.out.println(Arrays.toString(res));
        }
        return res[nums.length - 1];
    }
}
