package array.monotonicstack;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/number-of-visible-people-in-a-queue
 */
public class NumberOfVisiblePeopleToRight {
    public static void main(String[] args) {
        int[] sol = new NumberOfVisiblePeopleToRight().canSeePersonsCount(new int[]{4,3,2,1});
        System.out.println(Arrays.toString(sol));
    }

    public int[] canSeePersonsCount(final int[] heights) {
        final int[] result = new int[heights.length];
        Stack<Integer> s = new Stack<>();
        result[heights.length - 1] = 0;
        int visible = 0;
        s.push(heights[heights.length - 1]);
        for (int i = heights.length - 2; i >= 0; i--) {
            visible = 0;
            while (!s.isEmpty() && s.peek() < heights[i]) {
                s.pop();
                visible++;
            }
            if(!s.isEmpty()) {
                visible++;
            }
            result[i] = visible;
            s.push(heights[i]);
        }
        return result;
    }

    public int[] canSeePersonsCountbak(final int[] heights) {
        final int[] result = new int[heights.length], stack = new int[heights.length];
        int idx = -1;

        for (int i = 0; i < heights.length; ++i) {
            while (idx > -1 && heights[stack[idx]] <= heights[i])
                result[stack[idx--]]++;
            if (idx > -1)
                result[stack[idx]]++;
            stack[++idx] = i;
        }

        return result;
    }
}
