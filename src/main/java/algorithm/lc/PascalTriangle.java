package algorithm.lc;

import java.util.ArrayList;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5, Return
 * 
 * [ [1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1] ]
 */
public class PascalTriangle {

  // O(n^2) space, O(n^2) time
  public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
      // Start typing your Java solution below
      // DO NOT write main() function
      ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
      if (numRows == 0) {
        return res;
      }
      ArrayList<Integer> prev = new ArrayList<Integer>();
      prev.add(1);
      res.add(prev);
      for (int i = 1; i < numRows; ++i) {
        ArrayList<Integer> cur = new ArrayList<Integer>();
        cur.add(1);
        for (int c = 1; c < i; ++c) {
          cur.add(prev.get(c - 1) + prev.get(c));
        }
        cur.add(1);
        res.add(cur);
        prev = cur;
      }

      return res;
    }
  }

}
