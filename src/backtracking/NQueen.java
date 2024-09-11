package backtracking;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/n-queens/
 */
public class NQueen {
    public static void main(String[] args) {
        List<List<String>> res = new backtracking.NQueen().solveNQueens(4);
        System.out.println("Answer");
        res.forEach(System.out::print);
//        List<Character> temp = new ArrayList();
//        temp.sort((o1, o2) -> o2 - o1);
//        String pk = temp.stream().map(Object::toString).collect(Collectors.joining());
//        Collections.sort(temp);
//        System.out.println(pk);
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] c: board) {
            Arrays.fill(c, '.');
        }
        boolean[] diag1  = new boolean[2*n];
        boolean[] diag2  = new boolean[2*n];
        boolean[] col  = new boolean[n];
        // for(int i = 0; i< board.length; i++) {
        dfs(board, diag1, diag2, col, 0, n, result);
        // }
        return result;
    }

    private void dfs(final char[][] board, final boolean[] diag1, final boolean[] diag2, final boolean[] col, final int row, final int n, final List<List<String>> res) {
        System.out.println("row " + row);
        if(row == n) {
            System.out.println(Arrays.deepToString(board));
            res.add(Arrays.stream(board).map(String::new).collect(Collectors.toList()));
            // return true;
            return;
        }
        for(int i = 0; i< board.length; i++) {
            if(!diag1[row + i] && !diag2[n - row + i] && !col[i]) {
                diag1[row + i] = true;
                diag2[n - row + i] = true;
                col[i] = true;
                board[row][i] = 'Q';
                dfs(board, diag1, diag2, col, row+1, n, res);
                // if(dfs(board, diag1, diag2, col, row+1, n, res)) {
                //     return true;
                // }
                board[row][i] = '.';
                diag1[row + i] = false;
                diag2[n - row + i] = false;
                col[i] = false;
            }
        }
        // return false;
    }
//    public List<List<String>> solveNQueens(int n) {
//        List<List<String>> result = new ArrayList<>();
//        LinkedHashMap<String, List<String>> res = new LinkedHashMap<>();
//        char[][] board = new char[n][n];
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board.length; j++) {
//                for (char[] a : board) {
//                    Arrays.fill(a, '.');
//                }
//                board[i][j] = 'Q';
//                if (dfs(board, n - 1)) {
////                    if (i == 0 && j == 2) {
////                        System.out.println("possible");
////                        System.out.println(Arrays.deepToString(board));
////                    }
//                    res.putIfAbsent(Arrays.stream(board).map(String::new).collect(Collectors.joining()), Arrays.stream(board).map(String::new).collect(Collectors.toList()));
//                }
//                board[i][j] = '.';
//            }
//        }
//        res.forEach((k, v) -> result.add(v));
//        return result;
//    }
//
//    private boolean dfs(char[][] board, int n) {
//        if (n == 0) {
//            return true;
//        }
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board.length; j++) {
//                if (board[i][j] == '.' && isValid(board, i, j, board.length)) {
//                    board[i][j] = 'Q';
//                    if (dfs(board, n - 1)) {
//                        return true;
//                    }
//                    board[i][j] = '.';
//                }
//            }
//        }
//        return false;
//    }
//
//    private boolean isValid(char[][] board, int i, int j, int n) {
//        for (int k = 0; k < n; k++) {
//            if (board[i][k] == 'Q' || board[k][j] == 'Q') {
//                return false;
//            }
//        }
//        int p = i - Math.min(i, j), q = j - Math.min(i, j);
//        while (p < n && q < n) {
//            if (board[p][q] == 'Q') {
//                return false;
//            }
//            p++;
//            q++;
//        }
//        p = Math.min(i + j, n - 1);
//        q = i + j <= n - 1 ? 0 : (i + j) - (n - 1);
//        while (p >= 0 && q < n) {
//            if (board[p][q] == 'Q') {
//                return false;
//            }
//            p--;
//            q++;
//        }
//        return true;
//    }
}
