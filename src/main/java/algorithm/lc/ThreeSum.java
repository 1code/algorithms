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
      ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
      Arrays.sort(num);
      int i = 0;
      while (i < num.length - 1) {
        int j = i + 1;
        int k = num.length - 1;
        while (j < k) {
          int value = num[i] + num[k] + num[j];
          if (value < 0) {
            ++j;
          }
          else if (value > 0) {
            --k;
          }
          else {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(num[i]);
            list.add(num[j]);
            list.add(num[k]);
            results.add(list);
            ++j;
            --k;
            while (j < k && num[j] == num[j - 1]) {
              ++j;
            }
            while (j < k && num[k] == num[k + 1]) {
              --k;
            }
          }
        }
        ++i;
        while (i < k && num[i] == num[i - 1]) {
          ++i;
        }
      }
      
      return results;
    }
  }
  
}
