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
        for (int i = level; i < cols - level; ++i) {
          res.add(matrix[level][i]);
        }
        // add right 
        for (int c = level + 1; c < rows - level; ++c) {
          res.add(matrix[c][cols - level - 1]);
        }
        // add bottom
        if (level < rows - level - 1) {
          for (int i = cols - level - 2; i >= level; --i) {
            res.add(matrix[rows - level - 1][i]);
          }
        }
        // add left
        if (level < cols - level - 1) {
          for (int c = rows - level - 2; c > level; --c) {
            res.add(matrix[c][level]);
          }
        }
      }
      return res;
    }
  }

}
