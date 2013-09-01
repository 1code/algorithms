package algorithm.lc;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container.
 * 
 */
public class ContainerWithMostWater {

  // O(1) space, O(n) time
  public class Solution {
    // continuously fill the water with height 1, 2, and so on
    public int maxArea(int[] height) {
      // Start typing your Java solution below
      // DO NOT write main() function
      int highest = 0;
      for (int h : height) {
        highest = Math.max(highest, h);
      }

      int maxArea = 0;
      int left = 0;
      int right = height.length - 1;
      for (int i = 1; i <= highest; ++i) {
        while (height[left] < i && left < right) {
          ++left;
        }
        while (height[right] < i && left < right) {
          --right;
        }
        int width = right - left;
        maxArea = Math.max(i * width, maxArea);
      }

      return maxArea;
    }
  }

}