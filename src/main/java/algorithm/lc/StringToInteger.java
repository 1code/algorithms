package algorithm.lc;

/**
 * Implement atoi to convert a string to an integer. Hint: Carefully consider
 * all possible input cases. If you want a challenge, please do not see below
 * and ask yourself what are the possible input cases. Notes: It is intended for
 * this problem to be specified vaguely (ie, no given input specs). You are
 * responsible to gather all the input requirements up front.
 * 
 * Requirements for atoi: The function first discards as many whitespace
 * characters as necessary until the first non-whitespace character is found.
 * Then, starting from this character, takes an optional initial plus or minus
 * sign followed by as many numerical digits as possible, and interprets them as
 * a numerical value. The string can contain additional characters after those
 * that form the integral number, which are ignored and have no effect on the
 * behavior of this function. If the first sequence of non-whitespace characters
 * in str is not a valid integral number, or if no such sequence exists because
 * either str is empty or it contains only whitespace characters, no conversion
 * is performed. If no valid conversion could be performed, a zero value is
 * returned. If the correct value is out of the range of representable values,
 * INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 * 
 */
public class StringToInteger {

  // O(1) space, O(n) time
  public class Solution {
    public int atoi(String str) {
      // Start typing your Java solution below
      // DO NOT write main() function
      str = str.trim();
      if (str.length() == 0) {
        return 0;
      }

      int sign = 1;
      if (str.charAt(0) == '+' || str.charAt(0) == '-') {
        sign = str.charAt(0) == '-' ? -1 : 1;
        str = str.substring(1);
      }

      int res = 0;
      int max = (sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE);
      for (int i = 0; i < str.length(); ++i) {
        char ch = str.charAt(i);
        if (ch < '0' || ch > '9') {
          return res;
        }
        int digit = ch - '0';
        // check overflow
        if (sign == 1 && (max - digit) / 10 < res) {
          return max;
        } else if (sign == -1 && (max + digit) / 10 > res) {
          return max;
        }

        res = res * 10 + sign * digit;
      }
      return res;
    }
  }

}
