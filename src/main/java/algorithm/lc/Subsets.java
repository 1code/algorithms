package algorithm.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 * Note:
 * 
 * Elements in a subset must be in non-descending order. The solution set must
 * not contain duplicate subsets. For example, If S = [1,2,3], a solution is:
 * 
 * [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 * 
 */
// O(2^n) space, O(2^n) time
public class Subsets {

  public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
      // Start typing your Java solution below
      // DO NOT write main() function
      Set<ArrayList<Integer>> resSet = new HashSet<ArrayList<Integer>>();
      int curIdx = 0;
      ArrayList<Integer> curRes = new ArrayList<Integer>();
      Arrays.sort(num);
      subset(curIdx, curRes, resSet, num);
      return new ArrayList<ArrayList<Integer>>(resSet);
    }

    private void subset(int curIdx, ArrayList<Integer> curRes,
        Set<ArrayList<Integer>> res, int[] num) {
      if (curIdx == num.length) {
        res.add(curRes);
      } else if (curIdx < num.length) {
        // include cur
        ArrayList<Integer> copy = new ArrayList<Integer>(curRes);
        copy.add(num[curIdx]);
        subset(curIdx + 1, copy, res, num);
        // not include cur
        subset(curIdx + 1, curRes, res, num);
      }
    }
  }

}
