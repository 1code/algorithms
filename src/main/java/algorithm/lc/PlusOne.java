package algorithm.lc;

/**
 * Given a number represented as an array of digits, plus one to the number. 
 *
 */
// O(n) space, O(n) time
public class PlusOne {
  
  public class Solution {
    public int[] plusOne(int[] digits) {
          // Start typing your Java solution below
          // DO NOT write main() function
      int carry = 1;
      for (int i = digits.length - 1; i >= 0; --i) {
        digits[i] = carry + digits[i];
        if (digits[i] < 10) {
          carry = 0;
        }
        else {
          digits[i] -= 10;
        }
      }
      if (carry == 1) {
        int[] res = new int[digits.length + 1];
        for (int i = 0; i < digits.length; ++i) {
          res[i + 1] = digits[i];
        }
        res[0] = 1;
        return res;
      }
      else {
        return digits;
      }
    }
  }

}
