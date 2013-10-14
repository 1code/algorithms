package algorithm.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique
 * combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note:
 * 
 * All numbers (including target) will be positive integers. Elements in a
 * combination (a1, a2, ... , ak) must be in non-descending order. (ie, a1 <= a2
 * <= ... ? ak). The solution set must not contain duplicate combinations. For
 * example, given candidate set 2,3,6,7 and target 7, A solution set is: [7] [2,
 * 2, 3]
 * 
 */
public class CombinationSum {

  public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
        int target) {
      // Start typing your Java solution below
      // DO NOT write main() function
      Set<ArrayList<Integer>> res = new HashSet<ArrayList<Integer>>();
      int curIdx = 0;
      ArrayList<Integer> cur = new ArrayList<Integer>();
      int sum = 0;
      Arrays.sort(candidates);
      generate(candidates, target, res, curIdx, cur, sum);
      return new ArrayList<ArrayList<Integer>>(res);
    }

    private void generate(int[] candidates, int target,
        Set<ArrayList<Integer>> res, int curIdx, ArrayList<Integer> cur, int sum) {
      if (curIdx == candidates.length) {
        if (sum == target) {
          res.add(cur);
        }
        return;
      }
      int curVal = candidates[curIdx];
      if (sum + curVal <= target) {
        ArrayList<Integer> stay = new ArrayList<Integer>(cur);
        stay.add(curVal);
        generate(candidates, target, res, curIdx, stay, sum + curVal);
        ArrayList<Integer> next = new ArrayList<Integer>(cur);
        next.add(curVal);
        generate(candidates, target, res, curIdx + 1, next, sum + curVal);
      }
      generate(candidates, target, res, curIdx + 1, cur, sum);
    }
  }

}
