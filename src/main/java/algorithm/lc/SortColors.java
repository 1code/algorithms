package algorithm.lc;

/**
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 * Follow up: A rather straight forward solution is a two-pass algorithm using
 * counting sort. First, iterate the array counting number of 0's, 1's, and 2's,
 * then overwrite array with total number of 0's, then 1's and followed by 2's.
 * 
 * Could you come up with an one-pass algorithm using only constant space?
 * 
 */
// O(1) space, O(n) time
public class SortColors {

  public class Solution {
    // two pointers
    public void sortColors(int[] A) {
      // Start typing your Java solution below
      // DO NOT write main() function
      int redPos = 0;
      int bluePos = A.length - 1;
      int cur = 0;
      while (cur <= bluePos) {
        if (A[cur] == 0) { // meet red, move to the red area
          int tmp = A[redPos];
          A[redPos] = A[cur];
          A[cur] = tmp;
          ++redPos;
          ++cur;
        } else if (A[cur] == 2) { // meet blue, move to the blue area
          int tmp = A[bluePos];
          A[bluePos] = A[cur];
          A[cur] = tmp;
          --bluePos;
        } else {
          ++cur;
        }
      }
    }
  }

}
