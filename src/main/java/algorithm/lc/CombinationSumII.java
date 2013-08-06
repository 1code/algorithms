package algorithm.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all
 * unique combinations in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note:
 * 
 * All numbers (including target) will be positive integers. Elements in a
 * combination (a1, a2, � , ak) must be in non-descending order. (ie, a1 ? a2 ?
 * � ? ak). The solution set must not contain duplicate combinations. For
 * example, given candidate set 10,1,2,7,6,1,5 and target 8, A solution set is:
 * [1, 7] [1, 2, 5] [2, 6] [1, 1, 6]
 * 
 */
public class CombinationSumII {
  
  public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
          // Start typing your Java solution below
          // DO NOT write main() function
      Set<ArrayList<Integer>> res = new HashSet<ArrayList<Integer>>();
      Arrays.sort(candidates);
      search(new ArrayList<Integer>(), 0, 0, res, target, candidates);
      return new ArrayList<ArrayList<Integer>>(res);
    }
    
    private void search(ArrayList<Integer> curRes, int curIdx, int curSum, Set<ArrayList<Integer>> res, int target, int[] candidates) {
      if (curSum == target) {
        res.add(curRes);
      }
      if (curIdx == candidates.length) {
        return;
      }
      else {
        int cur = candidates[curIdx];
        if (curSum + cur > target) {
          return;  // prune
        }
        else {
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
