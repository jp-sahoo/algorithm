package array;

import java.util.Stack;

public class MaximumDurationInProfit {
    public static void main(String[] args) {
        int res = new MaximumDurationInProfit().getMaxDuration(new int[]{15, 12, 1,2,3,4,5,2,0,10});
        System.out.println(res);
    }
    int getMaxDuration(int[] a) {
        Stack<Integer> s = new Stack<>();
        int max = 0;
        for (int i = 1; i < a.length;) {
            while(i < a.length && a[i] > a[i-1]) {
                if(s.isEmpty()) {
                    max = Math.max(i, max);
                } else if(s.peek() < a[i]) {
                    while(!s.isEmpty() && s.peek() < a[i]) {
                        max = Math.max(i - s.pop(), max);
                    }
                    if(s.isEmpty()) {
                        max = Math.max(i, max);
                    }
                }
                i++;
            }
            while(i < a.length && a[i] <= a[i-1]) {
                s.push(i);
                i++;
            }
        }
        return max;
    }
}
