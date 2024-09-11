package array;

import java.util.*;

public class NumberOfSubarrayWithSumK {
    public static void main(String[] args) {
        int res = new NumberOfSubarrayWithSumK().subarraySumBak(new int[]{1, -1, 0}, 0);
        System.out.println(res);
    }
    public int subarraySumBak(int[] nums, int k) {
        // if(k==0) return 0;
        Map<Integer, Integer> map = new HashMap();
        int ans = 0;
        int prev = 0;
        // map.put(0, 0);
        for(int i = 0; i< nums.length; i++) {
            prev += nums[i];
            if(prev == k || map.containsKey(prev - k)) {
                ans++;
            }
            if(nums[i] == k) {
                ans++;
            }
            map.put(prev, i);
        }
        return ans;
    }

}
