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
  
//O(1) space, O(n) time
public class Solution {
 // continuously fill the water with height 1, 2, and so on
 public int maxArea(int[] height) {
       // Start typing your Java solution below
       // DO NOT write main() function
   int maxArea = 0;
   int maxHeight = 0;
   for (int h : height) {
     maxHeight = Math.max(maxHeight, h);
   }
   
   int left = 0;
   int right = height.length - 1;
   int curHeight = 0;
   
   while (curHeight <= maxHeight && left < right) {
     while (height[left] < curHeight && left < right) {
       ++left;
     }
     while (height[right] < curHeight && left < right) {
       --right;
     }
     int curArea = Math.min(height[left], height[right]) * (right - left);
     maxArea = Math.max(maxArea, curArea);
     ++curHeight;
   }
   
   return maxArea;
 }
}

}
