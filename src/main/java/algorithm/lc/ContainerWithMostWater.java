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
  //continuously fill the water with height 1, 2, and so on
  public class Solution {
    public int maxArea(int[] height) {
          // Note: The Solution object is instantiated only once and is reused by each test case.
      int maxWater = 0;
      int curHeight = 0;
      int left = 0;
      int right = height.length - 1;
      while (left < right) {
        ++curHeight;
        while (height[left] < curHeight && left < right) {
          ++left;
        }
        while (height[right] < curHeight && left < right) {
          --right;
        }
        maxWater = Math.max(maxWater, (right - left) * curHeight);
      }
      
      return maxWater;
    }
  }
  
}