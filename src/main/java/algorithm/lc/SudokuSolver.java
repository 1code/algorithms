package algorithm.lc;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * Empty cells are indicated by the character '.'.
 * 
 * You may assume that there will be only one unique solution.
 * 
 * A sudoku puzzle...
 * 
 */
// O(1) space, O(9^81) time 
public class SudokuSolver {

  public class Solution {
    // dfs
    public void solveSudoku(char[][] board) {
      // Start typing your Java solution below
      // DO NOT write main() function
      char[][] tmpBoard = new char[9][9];
      copyBoard(tmpBoard, board);
      solve(tmpBoard, 0, board);
    }

    private void solve(char[][] tmpBoard, int idx, char[][] board) {
      if (idx == 81) { // solved
        copyBoard(board, tmpBoard);
        return;
      }

      int row = idx / 9;
      int col = idx % 9;
      if (tmpBoard[row][col] != '.') { // skip already filled
        solve(tmpBoard, idx + 1, board);
      } else {
        for (int i = 1; i < 10; ++i) {
          if (validate(tmpBoard, row, col, i)) {
            tmpBoard[row][col] = (char) ('0' + i);
            solve(tmpBoard, idx + 1, board);
            tmpBoard[row][col] = '.';
          }
        }
      }
    }

    private boolean validate(char[][] tmpBoard, int row, int col, int num) {
      // check row, col
      char ch = (char) ('0' + num);
      for (int i = 0; i < 9; ++i) {
        if (tmpBoard[row][i] == ch || tmpBoard[i][col] == ch) {
          return false;
        }
      }
      // check block
      int rBase = row / 3 * 3;
      int cBase = col / 3 * 3;
      for (int i = 0; i < 9; ++i) {
        int r = rBase + i / 3;
        int c = cBase + i % 3;
        if (tmpBoard[r][c] == ch) {
          return false;
        }
      }
      return true;
    }

    private void copyBoard(char[][] dest, char[][] source) {
      for (int r = 0; r < dest.length; ++r) {
        for (int c = 0; c < dest[r].length; ++c) {
          dest[r][c] = source[r][c];
        }
      }
    }
  }

}
