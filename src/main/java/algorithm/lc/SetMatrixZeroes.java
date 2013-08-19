package algorithm.lc;

import java.util.Arrays;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in place.
 * 
 * Follow up: Did you use extra space? A straight forward solution using O(mn)
 * space is probably a bad idea. A simple improvement uses O(m + n) space, but
 * still not the best solution. Could you devise a constant space solution?
 * 
 */
public class SetMatrixZeroes {

  public class Solution {
    public void setZeroes(int[][] matrix) {
          // Start typing your Java solution below
          // DO NOT write main() function
      boolean firstColZero = false;
      
      for (int i = 0; i < matrix.length; ++i) {
        for (int j = 0; j < matrix[i].length; ++j) {
          if (matrix[i][j] == 0) {
            if (j == 0) {
              firstColZero = true;
            }
            else {
              matrix[0][j] = 0;
              matrix[i][0] = 0;
            }
          }
        }
      }
      
      for (int i = 1; i < matrix.length; ++i) {
        for (int j = 1; j < matrix[i].length; ++j) {
          if (matrix[0][j] == 0 || matrix[i][0] == 0) {
            matrix[i][j] = 0;
          }
        }
      }
      // check first row
      if (matrix[0][0] == 0) {
        Arrays.fill(matrix[0], 0);
      }
      
      if (firstColZero) {
        for (int i = 0; i < matrix.length; ++i) {
          matrix[i][0] = 0;
        }
      }
      
    }
  }

}
