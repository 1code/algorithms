package algorithm.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such
 * that a + b + c + d = target? Find all unique quadruplets in the array which
 * gives the sum of target.
 * 
 * Note:
 * 
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ?
 * b ? c ? d) The solution set must not contain duplicate quadruplets. For
 * example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * 
 * A solution set is: (-1, 0, 0, 1) (-2, -1, 1, 2) (-2, 0, 0, 2)
 * 
 */
// O(n^3) space, O(n^3) time
public class FourSum {

  public class Solution {
    // use two pointers inside a two-level nested loop
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
      // Start typing your Java solution below
      // DO NOT write main() function
      Arrays.sort(num);
      ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

      for (int i = 0; i < num.length - 3; ++i) {
        if (i > 0 && num[i] == num[i - 1]) {
          continue;
        }
        for (int j = i + 1; j < num.length - 2; ++j) {
          if (j > i + 1 && num[j] == num[j - 1]) {
            continue;
          }
          int k = j + 1;
          int l = num.length - 1;

          while (k < l) {
            int sum = num[i] + num[j] + num[k] + num[l];
            if (sum == target) {
              if (k > j + 1 && num[k] == num[k - 1]) {
                ++k;
                continue;
              }
              if (l < num.length - 1 && num[l] == num[l + 1]) {
                --l;
                continue;
              }
              ArrayList<Integer> quad = new ArrayList<Integer>();
              quad.add(num[i]);
              quad.add(num[j]);
              quad.add(num[k]);
              quad.add(num[l]);
              res.add(quad);
              --l;
              ++k;
            } else if (sum > target) {
              do {
                --l;
              } while (k < l && num[l] == num[l + 1]);
            } else {
              do {
                ++k;
              } while (k < l && num[k] == num[k - 1]);
            }
          }

        }
      }

      return res;
    }
  }

}
