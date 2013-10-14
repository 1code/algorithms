package algorithm.lc;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 */
public class ClimbingStairs {

  // 1D DP
  // O(n) space, O(n) time
  public class Solution {
    public int climbStairs(int n) {
      // Start typing your Java solution below
      // DO NOT write main() function
      if (n == 0) {
        return 0;
      } else if (n == 1) {
        return 1;
      }
      int[] ways = new int[n + 1];
      ways[0] = 0;
      ways[1] = 1;
      ways[2] = 2;
      for (int i = 3; i < ways.length; ++i) {
        ways[i] = ways[i - 1] + ways[i - 2];
      }
      return ways[n];
    }
  }
  
  // O(1) space, O(n) time
  public class Solution2 {
    public int climbStairs(int n) {
            // Start typing your Java solution below
            // DO NOT write main() function
      if (n == 0) {
        return 1;
      }
      else if (n == 1) {
        return 1;
      }
      int[] ways = new int[2];
      ways[0] = 1;
      ways[1] = 1;
      for (int i = 2; i < n + 1; ++i) {
        ways[(i - 2) % 2] = ways[((i - 2) % 2 + 1) % 2] + ways[(i - 2) % 2];
      }
      return ways[(n - 2) % 2];
    }
  }

}
