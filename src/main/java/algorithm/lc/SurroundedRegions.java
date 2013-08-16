package algorithm.lc;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region .
 * For example,
 *      X X X X
 *      X O O X
 *      X X O X
 *      X O X X
 * After running your function, the board should be:
 *      X X X X
 *      X X X X
 *      X X X X
 *      X O X X
 */
// O(mn) space, O(mn) time
public class SurroundedRegions {
  
  public class Solution {
    // use dfs start from the boundary 'O'
    public void solve(char[][] board) {
          // Start typing your Java solution below
          // DO NOT write main() function
      if (board == null) {
        return;
      }
      Queue<Point> queue = new LinkedList<Point>();
      for (int i = 0; i < board.length; ++i) {
        for (int j = 0; j < board[i].length; ++j) {
          // add 'O' at the boundary
          if ((i == 0 || i == board.length - 1 || j == 0 || j == board[i].length - 1) && board[i][j] == 'O') {
            queue.offer(new Point(i, j));
          }
        }
      }
      while (!queue.isEmpty()) {
        Point p = queue.poll();
        int i = p.i;
        int j = p.j;
        board[i][j] = 'V';
        if (i != 0 && board[i - 1][j] == 'O') {
          queue.offer(new Point(i - 1, j));
        }
        if (i != board.length - 1 && board[i + 1][j] == 'O') {
          queue.offer(new Point(i + 1, j));
        }
        if (j != 0 && board[i][j - 1] == 'O') {
          queue.offer(new Point(i, j - 1));
        }
        if (j != board[i].length - 1 && board[i][j + 1] == 'O') {
          queue.offer(new Point(i, j + 1));
        }
      }
      
      for (int i = 0; i < board.length; ++i) {
        for (int j = 0; j < board[i].length; ++j) {
          if (board[i][j] != 'X') {
            board[i][j] = (board[i][j] == 'V'?'O':'X');
          }
        }
      }
    }
    
    private class Point {
      int i;
      int j;
      public Point(int i, int j) {
        this.i = i;
        this.j = j;
      }
    }
    
  }

}
