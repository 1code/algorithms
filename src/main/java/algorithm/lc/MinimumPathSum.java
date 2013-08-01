package algorithm.lc;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 */
public class MinimumPathSum {

  public class Solution {
    // 2d DP
    public int minPathSum(int[][] grid) {
      // Start typing your Java solution below
      // DO NOT write main() function
      if (grid == null || grid.length == 0 || grid[0].length == 0) {
        return 0;
      }
      int[][] aux = new int[grid.length][grid[0].length];
      for (int i = 0; i < grid.length; ++i) {
        for (int j = 0; j < grid[i].length; ++j) {
          aux[i][j] = grid[i][j];
          if (i == 0 && j == 0) {
            aux[i][j] = grid[0][0];
          } else if (i == 0) { // first row
            aux[i][j] += aux[i][j - 1];
          } else if (j == 0) { // first col
            aux[i][j] += aux[i - 1][j];
          } else {
            aux[i][j] += Math.min(aux[i - 1][j], aux[i][j - 1]);
          }
        }
      }
      return aux[grid.length - 1][grid[0].length - 1];
    }
  }

}
