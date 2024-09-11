package array;

import java.util.LinkedList;
import java.util.List;

public class MajorityElement {
    public static void main(String[] args) {
        List<Integer> ans = new MajorityElement().majorityElement(new int[]{1, 2});
        ans.forEach(a-> System.out.print(a + ","));
    }
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new LinkedList<>();
        int first = Integer.MIN_VALUE;
        int sec = Integer.MIN_VALUE;
        int countFirst = 0, countSecond = 0;
        for(int n: nums) {
            if(first == n) {
                countFirst++;
            } else if(sec == n) {
                countSecond++;
            } else if (countFirst == 0) {
                countFirst++;
                first = n;
            } else if (countSecond == 0) {
                countSecond++;
                sec = n;
            } else {
                countFirst--;
                countSecond--;
            }
        }
        countFirst = 0;
        countSecond = 0;
        for(int n: nums) {
            if(n == first) {
                countFirst++;
            } else if(n == sec) {
                countSecond++;
            }
        }
        if(countFirst>nums.length/3) {
            list.add(first);
        }
        if(countSecond>nums.length/3) {
            list.add(sec);
        }
        return list;
    }
}
