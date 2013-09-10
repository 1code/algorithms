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
          // Start typing your Java solution below
          // DO NOT write main() function
      ArrayList<Integer> res = new ArrayList<Integer>();
      for (int i = 0; i < rowIndex; ++i) {
        res.add(1);
      }
      
      for (int i = 2; i < rowIndex; ++i) {
        int upperLeft = res.get(0);
        int upperRight = res.get(1);
        for (int j = 1; j < i; ++j) {
          res.set(j, upperLeft + upperRight);
          upperLeft = upperRight;
          upperRight = res.get(j + 1);
        }
        System.out.println(res.toString());
      }
      return res;
    }
  }

}