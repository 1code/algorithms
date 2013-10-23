package algorithm.lc;

import java.util.ArrayList;

/**
 * The gray code is a binary numeral system where two successive values differ
 * in only one bit.
 * 
 * Given a non-negative integer n representing the total number of bits in the
 * code, print the sequence of gray code. A gray code sequence must begin with
 * 0.
 * 
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 
 * 00 - 0 
 * 01 - 1 
 * 11 - 3 
 * 10 - 2 
 * 
 * Note: For a given n, a gray code sequence is not
 * uniquely defined.
 * 
 * For example, [0,2,3,1] is also a valid gray code sequence according to the
 * above definition.
 * 
 * For now, the judge is able to judge based on one instance of gray code
 * sequence. Sorry about that.
 * 
 */
// O(2^n) space, O(2^n) time
public class GrayCode {

  public static class Solution {
    // build list of n from list of n - 1
    // 1. get the reverse of the list
    // 2. add suffix 0 to original list, add suffix 1 to reversed list
    // 3. concatenate two lists
    public static ArrayList<Integer> grayCode(int n) {
      // Start typing your Java solution below
      // DO NOT write main() function
      ArrayList<StringBuilder> res = new ArrayList<StringBuilder>();
      if (n == 0) {
        ArrayList<Integer> zero = new ArrayList<Integer>();
        zero.add(0);
        return zero;
      }

      res.add(new StringBuilder().append(0));
      res.add(new StringBuilder().append(1));

      // generate gray codes
      for (int i = 0; i < n - 1; ++i) {
        ArrayList<StringBuilder> reflectListWithOne = new ArrayList<StringBuilder>();
        for (int j = res.size() - 1; j >= 0; --j) {
          StringBuilder sb = new StringBuilder(res.get(j).toString());
          reflectListWithOne.add(sb.append('1'));
        }
        for (int j = 0; j < res.size(); ++j) {
          StringBuilder sb = res.get(j);
          sb.append('0');
        }
        res.addAll(reflectListWithOne);
      }
      // convert to integer
      ArrayList<Integer> grayCodes = new ArrayList<Integer>();
      for (int i = 0; i < res.size(); ++i) {
        String str = res.get(i).toString();
        int val = 0;
        int base = 1;
        for (int d = 0; d < str.length(); ++d) { // actually reverse the order is also a valid sequences
          val += base * (str.charAt(d) - '0');
          base <<= 1;
        }
        grayCodes.add(val);
      }

      return grayCodes;
    }
  }

}
