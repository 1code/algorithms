package algorithm.lc;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note:
 * 
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ? b ?
 * c) The solution set must not contain duplicate triplets. For example, given
 * array S = {-1 0 1 2 -1 -4},
 * 
 * A solution set is: (-1, 0, 1) (-1, -1, 2)
 */
// O(n^3) space (to hold results), O(n^2) time
public class ThreeSum {

  public class Solution {
    // two pointers,
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
      // Start typing your Java solution below
      // DO NOT write main() function
      Arrays.sort(num);
      ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
      for (int i = 0; i < num.length - 2; ++i) {
        int j = i + 1;
        int k = num.length - 1;
        while (j < k) {
          int sum = num[i] + num[j] + num[k];
          if (sum == 0) {
            ArrayList<Integer> solution = new ArrayList<Integer>();
            solution.add(num[i]);
            solution.add(num[j]);
            solution.add(num[k]);
            res.add(solution);
            ++j;
            --k;
            while (j < k && num[j - 1] == num[j]) {
              ++j;
            }
            while (j < k && num[k + 1] == num[k]) {
              --k;
            }
          } else if (sum < 0) {
            ++j;
          } else if (sum > 0) {
            --k;
          }
        }
        while (i < k && num[i] == num[i + 1]) {
          ++i;
        }
      }
      return res;
    }
  }

}
