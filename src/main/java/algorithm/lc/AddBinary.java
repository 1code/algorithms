package algorithm.lc;

/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example, a = "11" b = "1" Return "100".
 * 
 */
public class AddBinary {

  // O(n) space, O(n) time
  public class Solution {
    public String addBinary(String a, String b) {
      // Start typing your Java solution below
      // DO NOT write main() function
      StringBuilder res = new StringBuilder();
      int i = a.length() - 1;
      int j = b.length() - 1;
      int carry = 0;
      while (i >= 0 || j >= 0) {
        int digit = 0;
        if (i >= 0) {
          digit += a.charAt(i--) - '0';
        }
        if (j >= 0) {
          digit += b.charAt(j--) - '0';
        }
        digit += carry;
        carry = digit / 2;
        digit %= 2;
        res.append(digit);
      }
      if (carry != 0) {
        res.append(carry);
      }
      return res.reverse().toString();
    }
  }

}
