package algorithm.lc;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given two integers n and k, return all possible combinations of k numbers out
 * of 1 ... n.
 * 
 * For example, If n = 4 and k = 2, a solution is:
 * 
 * [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 * 
 */
public class Combinations {

  // recursive solution
  public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
      // Start typing your Java solution below
      // DO NOT write main() function
      ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
      ArrayList<Integer> cur = new ArrayList<Integer>();
      int index = 0;
      combine(cur, index, n, k, res);
      return res;
    }

    private void combine(ArrayList<Integer> cur, int index, int n, int k,
        ArrayList<ArrayList<Integer>> res) {
      if (cur.size() == k) {
        res.add(cur);
        return;
      }
      if (index == n) {
        return;
      }
      // add element
      ArrayList<Integer> addCopy = new ArrayList<Integer>(cur);
      addCopy.add(index + 1);
      combine(addCopy, index + 1, n, k, res);
      // not to add element
      combine(cur, index + 1, n, k, res);
    }
  }
  
  // iterative solution
  public class Solution2 {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
          // Start typing your Java solution below
          // DO NOT write main() function
      ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
      ArrayList<Integer> cur = new ArrayList<Integer>();
      Pair pair = new Pair(0, cur);
      Stack<Pair> stack = new Stack<Pair>();
      stack.push(pair);
      
      while (!stack.isEmpty()) {
        Pair top = stack.pop();
        int nextIdx = top.nextIdx;
        ArrayList<Integer> list = top.list;
        if (list.size() == k) {
          res.add(list);
        }
        else if (nextIdx < n) {
          stack.push(new Pair(nextIdx + 1, new ArrayList<Integer>(list)));
          list.add(nextIdx + 1);
          stack.push(new Pair(nextIdx + 1, new ArrayList<Integer>(list)));
        }
      }
      
      return res;
    }
    
    public class Pair {
      public int nextIdx;
      public ArrayList<Integer> list;
      public Pair(int nextIdx, ArrayList<Integer> list) {
        this.nextIdx = nextIdx;
        this.list = list;
      }
    }
  }

}
