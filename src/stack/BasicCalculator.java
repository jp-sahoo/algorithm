package stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/basic-calculator/description/
 * Hard
 */
public class BasicCalculator {
    public static void main(String[] args) {
        int res = new BasicCalculator().calculate("(1+(4+5+2)-3)+(6+8)");
        System.out.println(res);
    }
    public int calculate(String s) {
        int result = 0;
        int temp = 0;
        int flag  = 1;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i< s.length(); i++) {
            char c = s.charAt(i);
            switch(c) {
                case ' ': {break;}
                case '+': {
                    flag = 1;
                    break;}
                case '-': {
                    flag = -1;
                    break;}
                case '(': {
                    st.push(result);
                    st.push(flag);
                    result = 0;
                    flag = 1;
                    break;}
                case ')': {
                    if(!st.empty()) {
                        result *= st.pop();//for the sign
                        result += st.pop();//for the value
                    }
                    break;
                }
                default: {
                    while(i <s.length() && Character.isDigit(s.charAt(i))) {
                        temp = temp * 10 + (s.charAt(i) - '0');
                        i++;
                    }
                    result += temp * flag;
                    temp = 0;
                    i--;
                }
            }
        }
        return result;
    }
}
