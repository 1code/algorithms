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
 * combination (a1, a2, � , ak) must be in non-descending order. (ie, a1 ? a2 ?
 * � ? ak). The solution set must not contain duplicate combinations. For
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
      Arrays.sort(candidates);
      search(new ArrayList<Integer>(), 0, 0, res, target, candidates);
      return new ArrayList<ArrayList<Integer>>(res);
    }

    private void search(ArrayList<Integer> curRes, int curIdx, int curSum,
        Set<ArrayList<Integer>> res, int target, int[] candidates) {
      if (curSum == target) {
        res.add(curRes);
      }
      if (curIdx == candidates.length) {
        return;
      } else {
        int cur = candidates[curIdx];
        if (curSum + cur > target) {
          return; // prune
        } else {
          // include repeated elem
          ArrayList<Integer> copyRepeat = new ArrayList<Integer>(curRes);
          copyRepeat.add(cur);
          search(copyRepeat, curIdx, curSum + cur, res, target, candidates);

          // not include and move to next elem
          search(curRes, curIdx + 1, curSum, res, target, candidates);

          // include cur elem and move to next elem
          ArrayList<Integer> copyNext = new ArrayList<Integer>(curRes);
          copyNext.add(cur);
          search(copyNext, curIdx + 1, curSum + cur, res, target, candidates);
        }
      }
    }
  }

}
