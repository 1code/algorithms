package algorithm.lc;

import java.util.ArrayList;

/**
 * Follow up for N-Queens problem.
 * 
 * Now, instead outputting board configurations, return the total number of
 * distinct solutions.
 * 
 */
public class NQueensII {

  // O(n) space, O(n!) time
  public class Solution {
    public int totalNQueens(int n) {
      // Start typing your Java solution below
      // DO NOT write main() function
      ArrayList<Integer> res = new ArrayList<Integer>();
      res.add(0);
      int[] history = new int[n];
      int curRow = 0;
      solve(history, n, curRow, res);
      return res.get(0);
    }

    private void solve(int[] history, int n, int curRow, ArrayList<Integer> res) {
      if (curRow == n) { // add to res
        res.set(0, res.get(0) + 1);
      } else {
        for (int c = 0; c < n; ++c) { // try position curIdx, c
          boolean canPut = true;
          for (int r = 0; r < curRow; ++r) {
            if (history[r] == c || c - curRow == history[r] - r // diagonal
                || c + curRow == history[r] + r) {
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
