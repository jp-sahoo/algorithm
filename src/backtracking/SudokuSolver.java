package backtracking;

/**
 * https://leetcode.com/problems/sudoku-solver/
 */
public class SudokuSolver {
    public static void main(String[] args) {
        new SudokuSolver().solveSudoku(new char[][]{{'.', 'q'}, {'.', 'p'}});
    }
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char[][] board) {
        for(int i = 0; i<board.length; i++) {
            for(int j = 0; j<board.length; j++) {
                if(board[i][j] == '.') {
                    for(char k = '1'; k<='9'; k++) {
                        if(isValid(board, i, j, k)) {
                            board[i][j] = k;
                            if(solve(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int i, int j, char c) {
        int minI = (i/3) * 3, minJ = (j/3) * 3, maxI = (i/3) * 3 + 2, maxJ = (j/3) * 3 + 2;
        int fI = minI, fJ = minJ;
        for(int k = 0; k < board.length; k++) {
            if(board[i][k] == c || board[k][j] == c || board[fI][fJ] == c){
                return false;
            }
            fJ++;
            if(fJ > maxJ) {
                fI++;
                fJ = minJ;
            }
        }
        return true;
    }
}
