package algorithm.lc;

import java.util.Arrays;

/**
 * Given a number represented as an array of digits, plus one to the number.
 * 
 */
public class PlusOne {

  // O(n) space, O(n) time
  public class Solution {
    public int[] plusOne(int[] digits) {
      // Start typing your Java solution below
      // DO NOT write main() function
      int[] res = new int[digits.length + 1];
      int carry = 1;
      for (int i = digits.length - 1; i >= 0; --i) {
        res[i + 1] = carry + digits[i];
        carry = res[i + 1] / 10;
        res[i + 1] = res[i + 1] % 10;
      }
      if (carry == 1) {
        res[0] = 1;
        return res;
      } else {
        return Arrays.copyOfRange(res, 1, res.length);
      }
    }
  }

}
