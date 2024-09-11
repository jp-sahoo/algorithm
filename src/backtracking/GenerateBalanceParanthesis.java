package backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/description/
 * pass 2 counter left and right, increment left till it reaches length n and keep adding ( for all increment
 * for all subsequent left increment try to balance out right
 * on terminal condition i.e when the length is 2n, add the string to the result.
 */
public class GenerateBalanceParanthesis {
    public static void main(String[] args) {
        List<String> list = new GenerateBalanceParanthesis().generateParenthesis(5);
        list.forEach(a -> System.out.println(a));
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList();
        dfs(0, 0, n, "", res);
        return res;
    }

    private void dfs(int left, int right, int n, String s, List<String> res) {
        if (n * 2 == s.length()) {
            res.add(s);
            return;
        }
        if (left < n)
            dfs(left + 1, right, n, s + "(", res);
        if (right < left)
            dfs(left, right + 1, n, s + ")", res);
    }
}
