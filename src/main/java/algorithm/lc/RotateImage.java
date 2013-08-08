package algorithm.lc;

/**
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Follow up: Could you do this in-place?
 * 
 */
// O(1) space, O(n^2) time
public class RotateImage {

  public class Solution {
    // rotate the matrix from outer to inner, layer by layer
    public void rotate(int[][] matrix) {
      // Start typing your Java solution below
      // DO NOT write main() function
      for (int layer = 0; layer < matrix.length / 2; ++layer) {
        int start = layer;
        int end = matrix.length - layer - 1;
        for (; start < end; ++start) {
          int tmp = matrix[layer][start];
          // replace top with left
          matrix[layer][start] = matrix[matrix.length - start - 1][layer];
          // replace left with bottom
          matrix[matrix.length - start - 1][layer] = matrix[matrix.length
              - layer - 1][matrix.length - start - 1];
          // replace bottom with right
          matrix[matrix.length - layer - 1][matrix.length - start - 1] = matrix[start][matrix.length
              - layer - 1];
          // replace right with top
          matrix[start][matrix.length - layer - 1] = tmp;

        }
      }
    }

  }

}
