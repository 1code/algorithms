package algorithm.lc;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to
 * n2 in spiral order.
 * 
 * For example, Given n = 3,
 * 
 * You should return the following matrix: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5
 * ] ]
 * 
 */
public class SpiralMatrixII {

  public class Solution {
    public int[][] generateMatrix(int n) {
      // Start typing your Java solution below
      // DO NOT write main() function
      int[][] matrix = new int[n][n];

      int maxLevel = matrix.length / 2;
      int cur = 0;
      for (int level = 0; level <= maxLevel; ++level) {
        // write top
        for (int i = level; i < n - level; ++i) {
          matrix[level][i] = ++cur;
        }
        // write right
        for (int i = level + 1; i < n - level; ++i) {
          matrix[i][n - level - 1] = ++cur;
        }
        // write bottom
        for (int i = n - level - 2; i >= level; --i) {
          matrix[n - level - 1][i] = ++cur;
        }
        // write left
        for (int i = n - level - 2; i > level; --i) {
          matrix[i][level] = ++cur;
        }
      }
      return matrix;
    }
  }

}
