package array.slidingwindow;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 *https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 * Question: get the size of the longest subarray whose maximum/minimum element has max difference as limit
 * 1. keep 2 pointer (i, j) keep adding element with increasing j
 * 2. always check if that window is valid of not.
 * 3. if invalid, keep removing element from back(i) till its valid
 */
public class LongestSubarrayDiffLessLimit {
    public static void main(String[] args) {
        int res = new LongestSubarrayDiffLessLimit().longestSubarray(new int[]{4,2,2,2,4,4,2,2}, 0);
//        int res = new LongestSubarrayDiffLessLimit().longestSubarray(new int[]{10,1,2,4,7,2}, 5);
        System.out.println(res);
    }

    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();
        int ans = 1;
        for (int i = 0, j = 0; j < nums.length; j++) {
            max.add(nums[j]);
            min.add(nums[j]);
            if (!isValid(max, min, limit)) {
                while (i <= j && !isValid(max, min, limit)) {
                    max.remove(nums[i]);
                    min.remove(nums[i]);
                    i++;
                }
                if (i > j)
                    i--;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }

    boolean isValid(PriorityQueue<Integer> max, PriorityQueue<Integer> min, int limit) {
        return max.isEmpty() || max.peek() - min.peek() <= limit;
    }

    boolean isValidBak(PriorityQueue<Integer> max, PriorityQueue<Integer> min, int limit, Integer next) {
        if (next == null) {
            return max.isEmpty() || Math.abs(max.peek() - min.peek()) <= limit;
        } else {
            if (max.isEmpty()) return true;
            int first = Math.max(max.peek(), next.intValue());
            int second = Math.min(min.peek(), next.intValue());
            return Math.abs(first - second) <= limit;
        }
    }
}
