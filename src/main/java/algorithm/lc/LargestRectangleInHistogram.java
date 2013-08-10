package algorithm.lc;


/**
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 * 
 * Above is a histogram where width of each bar is 1, given height =
 * [2,1,5,6,2,3].
 * 
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * 
 * For example, Given height = [2,1,5,6,2,3], return 10.
 * 
 */
// O(n) space, O(n) time
public class LargestRectangleInHistogram {
  
  public class Solution {
    // for each bin, find the distance to left boundary and distance to right boundary
    public int largestRectangleArea(int[] height) {
          // Start typing your Java solution below
          // DO NOT write main() function
      int max = 0;
      int[] distToLeft = new int[height.length];
      int[] distToRight = new int[height.length];
      int top = -1;
      int[] stack = new int[height.length];
      for (int i = 0; i < height.length; ++i) {
        while (top != -1 && height[i] <= height[stack[top]]) {
          --top;
        }
        distToLeft[i] = top == -1? i : i - stack[top] - 1;
        stack[++top] = i;
      }
      
      top = -1;
      for (int i = height.length - 1; i >= 0; --i) {
        while (top != -1 && height[i] <= height[stack[top]]) {
          --top;
        }
        distToRight[i] = top == -1? height.length - i - 1 : stack[top] - i - 1;
        stack[++top] = i;
      }
      
      for (int i = 0; i < height.length; ++i) {
        int area = height[i] * (distToLeft[i] + distToRight[i] + 1);
        if (area > max) {
          max = area;
        }
      }
      
      return max;
    }
  }
  
}
