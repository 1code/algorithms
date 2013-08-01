package algorithm.lc;

import java.util.Arrays;

/**
 * Given two numbers represented as strings, return multiplication of the
 * numbers as a string.
 * 
 * Note: The numbers can be arbitrarily large and are non-negative.
 * 
 */
// O(m+n) space, O(n * n) time
public class MultiplyStrings {

  public class Solution {
    public String multiply(String num1, String num2) {
      // Start typing your Java solution below
      // DO NOT write main() function
      int[] res = new int[num1.length() + num2.length()];
      Arrays.fill(res, 0);

      for (int i = num1.length() - 1; i >= 0; --i) {
        int carry = 0, j = num2.length() - 1, tmp;
        do {
          tmp = carry + res[i + j + 1] + (num1.charAt(i) - '0')
              * (num2.charAt(j) - '0');
          res[i + j + 1] = tmp % 10;
          carry = tmp / 10;
          --j;
        } while (j >= 0);
        res[i + j + 1] = carry; // put carry to higher digit
      }

      int i = 0;
      StringBuilder sb = new StringBuilder();
      while (i < res.length - 1 && res[i] == 0) {
        ++i;
      }
      while (i < res.length) {
        sb.append(res[i++]);
      }
      return sb.toString();
    }
  }

}
