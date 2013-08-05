package algorithm.lc;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled with
 * the character '.'.
 * 
 * A partially filled sudoku which is valid.
 * 
 */
public class ValidSudoku {
  
  public class Solution {
    public boolean isValidSudoku(char[][] board) {
          // Start typing your Java solution below
          // DO NOT write main() function
      // valid row
      boolean[][] rows = new boolean[9][9];
      boolean[][] cols = new boolean[9][9];
      boolean[][] blks = new boolean[9][9];
      
      for (int r = 0; r < board.length; ++r) {
        for (int c = 0; c < board[r].length; ++c) {
          if (board[r][c] == '.') {
            continue;
          }
          int value = board[r][c] - '1';
          if (rows[r][value] || cols[c][value] || blks[r / 3 * 3 + c / 3][value]) {
            return false;
          }
          rows[r][value] = cols[c][value] = blks[r / 3 * 3 + c / 3][value] = true;
        }
      }
      
      return true;
    }
  }

}
