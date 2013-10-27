package algorithm.lc;

/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In
 * this case, 6 units of rain water (blue section) are being trapped.
 * 
 */
public class TrappingRainWater {
  // O(n) space, O(n) time
  public class Solution {
    public int trap(int[] A) {
          // Note: The Solution object is instantiated only once and is reused by each test case.
      // for each bin, calculate the left highest and right highest bar
      int[] left = new int[A.length];
      int leftMax = 0;
      for (int i = 0; i < A.length; ++i) {
        left[i] = Math.max(A[i], leftMax);
        leftMax = Math.max(leftMax, A[i]);
      }
      
      int[] right = new int[A.length];
      int rightMax = 0;
      for (int i = A.length - 1; i >= 0; --i) {
        right[i] = Math.max(A[i], rightMax);
        rightMax = Math.max(rightMax, A[i]);
      }
      
      int water = 0;
      for (int i = 0; i < left.length; ++i) {
        int height = Math.min(left[i], right[i]);
        water += height - A[i];
      }
      
      return water;
    }
  }

}
