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
// O(n) space, O(n) time
public class TrappingRainWater {

  public class Solution {
    // for each position, record the highest bars on the left and right
    public int trap(int[] A) {
      // Start typing your Java solution below
      // DO NOT write main() function
      int[] leftBar = new int[A.length];
      int[] rightBar = new int[A.length];

      for (int i = 1; i < A.length; ++i) {
        leftBar[i] = Math.max(leftBar[i - 1], A[i - 1]);
      }

      for (int i = A.length - 2; i >= 0; --i) {
        rightBar[i] = Math.max(rightBar[i + 1], A[i + 1]);
      }
      int water = 0;
      for (int i = 1; i < A.length - 1; ++i) {
        int lowBar = Math.min(leftBar[i], rightBar[i]);
        if (lowBar > A[i]) {
          water += lowBar - A[i];
        }
      }
      return water;
    }
  }

}
