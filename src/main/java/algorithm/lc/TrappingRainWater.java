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
    // keep track of left highest and right highest respectively
    public int trap(int[] A) {
      // Start typing your Java solution below
      // DO NOT write main() function
      int[] leftMax = new int[A.length];
      int leftHighest = 0;
      for (int i = 0; i < A.length; ++i) {
        leftMax[i] = (A[i] >= leftHighest ? A[i] : leftHighest);
        leftHighest = Math.max(leftHighest, A[i]);
      }

      int[] rightMax = new int[A.length];
      int rightHighest = 0;
      for (int i = A.length - 1; i >= 0; --i) {
        rightMax[i] = (A[i] >= rightHighest ? A[i] : rightHighest);
        rightHighest = Math.max(rightHighest, A[i]);
      }

      int water = 0;
      for (int i = 0; i < A.length; ++i) {
        int h = Math.min(leftMax[i], rightMax[i]);
        water += h - A[i];
      }
      return water;
    }
  }

}
