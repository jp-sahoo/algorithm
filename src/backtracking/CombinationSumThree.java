package backtracking;

import java.util.*;

/***
 * https://leetcode.com/problems/combination-sum-iii/
 */
public class CombinationSumThree {
    public static void main(String[] args) {
        List<List<Integer>> res = new CombinationSumThree().combinationSum3(3, 10);
        res.forEach(a -> System.out.println(a));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> temp = new LinkedList<>();
        dfs(n, k, 1, temp, res);
        return res;
    }

    private void dfs(int n, int k, int start, List<Integer> temp, List<List<Integer>> res) {
        if (k == 0) {
            if (n == 0) {
                res.add(new LinkedList<>(temp));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (i > n) break;
            temp.add(i);
            dfs(n - i, k - 1, i + 1, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}
