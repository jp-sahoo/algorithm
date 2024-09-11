package array;

import java.util.*;

/**
 *https://leetcode.com/problems/maximum-good-subarray-sum/
 */
public class MaxGoodSubArraySum {
    public static void main(String[] args) {
//        long res = new array.MaxGoodSubArraySum().maximumSubarraySum(new int[]{1,5}, 4);
        System.out.println("jyoti".substring(0, "jyoti".length() -1));
        Deque<Character> c = new LinkedList<>();
//        c.
        NavigableSet<Integer> sortedSet = new TreeSet<>();

        sortedSet.add(10);
//        sortedSet.add(9);
//        sortedSet.add(8);
//        sortedSet.add(100);
//        sortedSet.add(70);
//        sortedSet.add(5);
//        System.out.println(sortedSet.size());
////        int q = sortedSet.
//        System.out.println(sortedSet.pollLast());
//        System.out.println(sortedSet.pollLast());
//        Integer a = sortedSet.higher(7);
//        Integer b = sortedSet.floor(9);
//
//        System.out.println(a + " " + b + " "+ q);
//        System.out.println(sortedSet.size());

    }
    public long maximumSubarraySum(int[] nums, int k) {
        long[] ans = new long[nums.length];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        long max = Long.MIN_VALUE;
        ans[0] = nums[0];
        map.put(nums[0] + k, new HashSet<>());
        map.get(nums[0] + k).add(0);
        map.put(nums[0] - k, new HashSet<>());
        map.get(nums[0] - k).add(0);
        System.out.print("map: ");
        map.forEach((p, q) -> System.out.print(p + "-" + q + " "));
        System.out.println("ans: " + Arrays.toString(ans));

        for(int i = 1; i< nums.length;i++) {
            ans[i] = ans[i-1] + nums[i];
            map.putIfAbsent(nums[i] + k, new HashSet<>());
            map.putIfAbsent(nums[i] - k, new HashSet<>());
            map.get(nums[i] + k).add(i);
            map.get(nums[i] - k).add(i);
            System.out.print("map: for " + i + " ");
            map.forEach((p, q) -> System.out.print(p + "-" + q + " "));
            System.out.println("ans: " + Arrays.toString(ans));
            if(map.containsKey(nums[i])) {
                Set<Integer> s = map.get(nums[i]);
                for (Integer j : s) {
                    System.out.println("final i and j" + i + " " + j);
                    max = Math.max(max, ans[Math.max(i, j)] - (Math.min(i, j) > 0 ? ans[Math.min(i, j) -1] : 0));
                }
            }
        }
        return max;
    }

}
