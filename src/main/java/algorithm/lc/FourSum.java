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
      ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
      Arrays.sort(num);
      Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
      
      for (int i = 0; i < num.length - 3; ++i) {
        for (int j = i + 1; j < num.length - 2; ++j) {
          int k = j + 1;
          int l = num.length - 1;
          while (k < l) {
            int sum = num[i] + num[j] + num[k] + num[l];
            if (sum == target) {
              ArrayList<Integer> list = new ArrayList<Integer>();
              list.add(num[i]);
              list.add(num[j]);
              list.add(num[k]);
              list.add(num[l]);
              if (set.add(list)) {
                res.add(list);
              }
              ++k;
              --l;
            }
            else if (sum > target) {
              --l;
            }
            else {
              ++k;
            }
          }
        }
      }
      return res;
    }
  }

}
