package algorithm.lc;

import java.util.ArrayList;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * For example, Given the following matrix:
 * 
 * [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ] You should return
 * [1,2,3,6,9,8,7,4,5].
 * 
 */
// O(1) space, O(nm) time
public class SpiralMatrix {
  
  public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
          // Start typing your Java solution below
          // DO NOT write main() function
      ArrayList<Integer> res = new ArrayList<Integer>();
      if (matrix == null || matrix.length == 0) {
        return res;
      }
      int rows = matrix.length;
      int cols = matrix[0].length;
      int maxLevel = rows < cols? (rows + 1) / 2 : (cols + 1) / 2;
      
      for (int level = 0; level < maxLevel; ++level) {
        // add top
        for (int c = level; c < cols - level; ++c) {
          res.add(matrix[level][c]);
        }
        // add right 
        for (int r = level + 1; r < rows - level; ++r) {
          res.add(matrix[r][cols - level - 1]);
        }
        // add bottom
        if (2 * level < rows - 1) {
          for (int c = cols - level - 2; c >= level; --c) {
            res.add(matrix[rows - level - 1][c]);
          }
        }
        // add left
        if (2 * level < cols - 1) {
          for (int r = rows - level - 2; r > level; --r) {
            res.add(matrix[r][level]);
          }
        }
      }
      return res;
    }
  }

}
