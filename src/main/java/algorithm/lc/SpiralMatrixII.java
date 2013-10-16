package algorithm.lc;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to
 * n2 in spiral order.
 * 
 * For example, Given n = 3,
 * 
 * You should return the following matrix: 
 * [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5] ]
 * 
 */
public class SpiralMatrixII {

  public class Solution {
    public int[][] generateMatrix(int n) {
          // Start typing your Java solution below
          // DO NOT write main() function
      int[][] mat = new int[n][n];
      int val = 1;
      int maxLevel = (n + 1) / 2;
      for (int level = 0; level < maxLevel; ++level) {
        for (int c = level; c < n - level; ++c) {
          mat[level][c] = val++;
        }
        
        for (int r = level + 1; r < n - level; ++r) {
          mat[r][n - level - 1] = val++;
        }
        
        if (2 * level < n - 1) { // has enough row and col
          for (int c = n - level - 2; c >= level; --c) {
            mat[n - level - 1][c] = val++;
          }
          for (int r = n - level - 2; r > level; --r) {
            mat[r][level] = val++;
          }
        }
      }
      return mat;
    }
  }

}
