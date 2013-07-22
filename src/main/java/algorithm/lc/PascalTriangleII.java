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
  public ArrayList<Integer> getRow(int rowIndex) {
    // Start typing your Java solution below
    // DO NOT write main() function
    ArrayList<Integer> cur = new ArrayList<Integer>();
    for (int i = 0; i < rowIndex + 1; ++i) {
      cur.add(1);
    }
    if (rowIndex < 2) {
      return cur;
    }

    for (int i = 2; i < rowIndex + 1; ++i) {
      int upperLeft = cur.get(0);
      int upperRight = cur.get(1);
      for (int j = 1; j < i; ++j) {
        cur.set(j, upperLeft + upperRight);
        upperLeft = upperRight;
        upperRight = cur.get(j + 1);
      }
    }
    return cur;
  }

}
