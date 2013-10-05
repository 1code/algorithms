package algorithm.lc;


/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 * 
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray
 * [4,−1,2,1] has the largest sum = 6.
 * 
 */
public class MaximumSubArray {

  // O(1) space, O(n) time
  public class Solution {
    public int maxSubArray(int[] A) {
      // Start typing your Java solution below
      // DO NOT write main() function
      if (A.length == 0) {
        return 0;
      }
      boolean allNeg = true;
      int maxSoFar = 0;
      int max = 0;
      int maxNeg = Integer.MIN_VALUE;
      for (int i = 0; i < A.length; ++i) {
        if (A[i] >= 0) {
          allNeg = false;
        }
        maxNeg = A[i] < 0 ? Math.max(maxNeg, A[i]) : maxNeg;
        maxSoFar = Math.max(maxSoFar + A[i], 0);
        max = Math.max(max, maxSoFar);
      }
      return allNeg ? maxNeg : max;
    }
  }

}
