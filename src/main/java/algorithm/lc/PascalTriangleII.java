package algorithm.lc;

import java.util.ArrayList;
import java.util.Arrays;

/*
 Given an index k, return the kth row of the Pascal's triangle.

 For example, given k = 3,
 Return [1,3,3,1].

 Note:
 Could you optimize your algorithm to use only O(k) extra space?
 */
// O(k) space, O(k) time
public class PascalTriangleII {

  // reuse the arraylist
  public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
          // Note: The Solution object is instantiated only once and is reused by each test case.
      ArrayList<Integer> res = new ArrayList<Integer>();
      for (int i = 0; i < rowIndex + 1; ++i) {
        res.add(1);
      }
      
      for (int level = 0; level < rowIndex + 1; ++level) {
        int upperLeft = res.get(0);
        for (int c = 1; c < level; ++c) {
          int upper = res.get(c);
          res.set(c, upperLeft + upper);
          upperLeft = upper;
        }
      }
      
      return res;
    }
  }

}