package algorithm.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given a collection of integers that might contain duplicates, S, return all
 * possible subsets.
 * 
 * Note:
 * 
 * Elements in a subset must be in non-descending order. The solution set must
 * not contain duplicate subsets. For example, If S = [1,2,2], a solution is:
 * 
 * [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 * 
 */
// O(2^n) space, O(2^n) time
public class SubsetsII {

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
  
  public class SolutionRecursive {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
          // Start typing your Java solution below
          // DO NOT write main() function
      Set<ArrayList<Integer>> res = new HashSet<ArrayList<Integer>>();
      Arrays.sort(S);
      Pair first = new Pair(0, new ArrayList<Integer>());
      Queue<Pair> queue = new LinkedList<Pair>();
      queue.offer(first);
      while (!queue.isEmpty()) {
        Pair cur = queue.poll();
        int idx = cur.curIdx;
        ArrayList<Integer> list = cur.list;
        if (idx == S.length) {
          res.add(list);
        }
        else {
          queue.offer(new Pair(idx + 1, list));
          ArrayList<Integer> copy = new ArrayList<Integer>(list);
          copy.add(S[idx]);
          queue.offer(new Pair(idx + 1, copy));
        }
      }
      return new ArrayList<ArrayList<Integer>>(res);
    }
    
    public class Pair {
      int curIdx;
      ArrayList<Integer> list;
      public Pair(int idx, ArrayList<Integer> list) {
        this.curIdx = idx;
        this.list = list;
      }
    }
  }

}
