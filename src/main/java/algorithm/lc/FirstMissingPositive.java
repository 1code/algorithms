package algorithm.lc;

import java.util.Arrays;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 */
// O(1) space, O(n) time
public class FirstMissingPositive {

  public class Solution {
    // if size of A is n, create an boolean array with size n + 1,
    // the nth elements indicate whether the number n + 1 appears
    public int firstMissingPositive(int[] A) {
      // Start typing your Java solution below
      // DO NOT write main() function
      if (A.length == 0) {
        return 1;
      }

      boolean[] missing = new boolean[A.length + 1];
      Arrays.fill(missing, true);
      for (int i = 0; i < A.length; ++i) {
        if (A[i] > 0 && A[i] < missing.length) {
          missing[A[i] - 1] = false;
        }
      }

      int result = 1;
      for (int i = 0; i < missing.length; ++i) {
        if (missing[i]) {
          result = i + 1;
          break;
        }
      }

      return result;
    }
  }

}
