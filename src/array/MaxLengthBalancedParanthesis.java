package array;

import java.util.Stack;

public class MaxLengthBalancedParanthesis {
    public static void main(String[] args) {
        int res = new MaxLengthBalancedParanthesis().longestValidParentheses(")()()");
        System.out.println(res);
    }

    public int longestValidParentheses(String p) {
        Stack<Integer> s = new Stack();
        s.push(-1);
        int max = 0;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c == '(') {
                System.out.print("if i " + i + "\n");
                s.push(i);
                s.forEach(a -> System.out.print(a));
                System.out.println();
            } else {
                s.pop();
                if (s.isEmpty()) {
                    System.out.print("else if i " + i + "\n");
                    s.push(i);
                } else {
                    System.out.print("else else i " + i + "\n");
                    int len = i - s.peek();
//                    s.forEach(a -> System.out.print(a));
                    max = Math.max(len, max);
                }
                s.forEach(a -> System.out.print(a));
                System.out.println();
            }
        }
        return max;
    }
}
