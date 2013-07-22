package algorithm.lc;

import java.util.ArrayList;

/**
 Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
public class PascalTriangle {
  
  public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
          // Start typing your Java solution below
          // DO NOT write main() function
      ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
      if (numRows == 0) {
        return res;
      }
      ArrayList<Integer> first = new ArrayList<Integer>();
      first.add(1);
      res.add(first);
      for (int i = 1; i < numRows; ++i) {
        ArrayList<Integer> prev = res.get(i - 1);
        ArrayList<Integer> cur = new ArrayList<Integer>();
        for (int j = 0; j < prev.size() + 1; ++j) {
          if (j == 0 || j == prev.size()) {
            cur.add(1);
          }
          else {
            cur.add(prev.get(j - 1) + prev.get(j));
          }
        }
        res.add(cur);
      }
      
      return res;
    }
  }

}
