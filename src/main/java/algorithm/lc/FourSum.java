package algorithm.lc;

import java.util.ArrayList;
import java.util.Arrays;

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
        if (i > 0 && num[i] == num[i - 1]) { // skip duplicate
          continue;
        }
        for (int j = i + 1; j < num.length - 2; ++j) {
          if (j > i + 1 && num[j] == num[j - 1]) { // skip duplicate
            continue; 
          }
          int k = j + 1;
          int l = num.length - 1;
          while (k < l) {
            int sum = num[i] + num[j] + num[k] + num[l];
            if (sum < target) {
              ++k;
              while (k > j + 1 && k < l && num[k] == num[k - 1]) { // skip duplicate
                ++k;
              }
            }
            else if (sum > target) {
              --l;
              while (k < l && num[l] == num[l + 1]) {  // skip duplicate
                --l;
              }
            }
            else {
              ArrayList<Integer> sol = new ArrayList<Integer>();
              sol.add(num[i]);
              sol.add(num[j]);
              sol.add(num[k]);
              sol.add(num[l]);
              res.add(sol);
              ++k;
              --l;
              while (k > j + 1 && k < l && num[k] == num[k - 1]) { // skip duplicate
                ++k;
              }
              while (k < l && num[l] == num[l + 1]) {  // skip duplicate
                --l;
              }
            }
            
          }
        }
      }
      
      return res;
    }
  }

}
