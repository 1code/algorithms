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
      Pair pair = new Pair(0, new ArrayList<Integer>());
      Stack<Pair> stack = new Stack<Pair>();
      stack.push(pair);
      while (!stack.isEmpty()) {
        Pair cur = stack.pop();
        ArrayList<Integer> list = cur.list;
        if (list.size() == k) {
          res.add(list);
        }
        else if (cur.curIdx < n) {
          ArrayList<Integer> listWithout = new ArrayList<Integer>(list);
          stack.push(new Pair(cur.curIdx + 1, listWithout));
          ArrayList<Integer> listWith = new ArrayList<Integer>(list);
          listWith.add(cur.curIdx + 1);
          stack.push(new Pair(cur.curIdx + 1, listWith));
        }
      }
      
      return res;
    }
    
    public class Pair {
      int curIdx;
      ArrayList<Integer> list;
      public Pair(int curIdx, ArrayList<Integer> list) {
        this.curIdx = curIdx;
        this.list = list;
      }
    }
  }
  
  public class Solution3 {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
          // Note: The Solution object is instantiated only once and is reused by each test case.
      int[] num = new int[n];
      for (int i = 0; i < n; ++i) {
        num[i] = i + 1;
      }
      ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
      
      if (k == 0) {
        return res;
      }
      
      for (int i = 0; i < n; ++i) {
        ArrayList<Integer> cur = new ArrayList<Integer>();
        cur.add(num[i]);
        res.add(cur);
      }
      
      for (int i = 1; i < k; ++i) {
        ArrayList<ArrayList<Integer>> next = new ArrayList<ArrayList<Integer>>();
        for (ArrayList<Integer> cur : res) {
          for (int j = 0; j < num.length; ++j) {
            if (num[j] > cur.get(cur.size() - 1)) {
              ArrayList<Integer> newList = new ArrayList<Integer>(cur);
              newList.add(num[j]);
              next.add(newList);
            }
          }
        }
        res = next;
      }
      
      return res;
    }
  }
  
}
