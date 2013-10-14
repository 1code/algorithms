package algorithm.lc;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The n-queens puzzle is the problem of placing n queens on an n*n chessboard
 * such that no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 * 
 */
public class NQueens {

  // O(n) space, O(n!) time
  public class Solution {
    // DFS
    public ArrayList<String[]> solveNQueens(int n) {
      // Start typing your Java solution below
      // DO NOT write main() function
      ArrayList<String[]> res = new ArrayList<String[]>();
      int[] history = new int[n];
      int curRow = 0;
      solve(history, n, curRow, res);
      return res;
    }

    private void solve(int[] history, int n, int curRow, ArrayList<String[]> res) {
      if (curRow == n) { // add to res
        String[] solved = new String[n];
        for (int i = 0; i < n; ++i) {
          char[] row = new char[n];
          Arrays.fill(row, '.');
          row[history[i]] = 'Q';
          solved[i] = new String(row);
        }
        res.add(solved);
      } else {
        for (int c = 0; c < n; ++c) { // try position curIdx, c
          boolean canPut = true;
          for (int r = 0; r < curRow; ++r) {
            if (history[r] == c || c - curRow == history[r] - r // diagonal
                || c + curRow == history[r] + r) { // anti-diagonal
              canPut = false;
              break;
            }
          }
          if (canPut) {
            history[curRow] = c;
            solve(history, n, curRow + 1, res);
          }
        }
      }
    }
  }

}
