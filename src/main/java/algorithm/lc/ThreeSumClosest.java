package algorithm.lc;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers. You
 * may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {

  public class Solution {
    // similar to 3Sum, but keep the current closest
    public int threeSumClosest(int[] num, int target) {
      // Start typing your Java solution below
      // DO NOT write main() function
      int closest = 0;
      int diff = Integer.MAX_VALUE;
      int i = 0;
      Arrays.sort(num);
      while (i < num.length - 1) {
        int j = i + 1;
        int k = num.length - 1;
        while (j < k) {
          int value = num[i] + num[j] + num[k];
          int curDiff = Math.abs(value - target);
          if (value - target == 0) {
            return value; // since it is assumed there is only one solution
          } else if (value - target < 0) {
            ++j;
          } else if (value - target > 0) {
            --k;
          }
          if (curDiff < diff) { // update closest
            closest = value;
            diff = curDiff;
          }
        }
        ++i;
      }
      return closest;
    }
  }

}
