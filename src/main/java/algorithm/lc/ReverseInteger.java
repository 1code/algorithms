package algorithm.lc;

/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 * 
 * Have you thought about this? Here are some good questions to ask before
 * coding. Bonus points for you if you have already thought through this!
 * 
 * If the integer's last digit is 0, what should the output be? ie, cases such
 * as 10, 100.
 * 
 * Did you notice that the reversed integer might overflow? Assume the input is
 * a 32-bit integer, then the reverse of 1000000003 overflows. How should you
 * handle such cases?
 * 
 * Throw an exception? Good, but what if throwing an exception is not an option?
 * You would then have to re-design the function (ie, add an extra parameter).
 * 
 */
// O(n) space, O(n) time, where n is the length of digit.
public class ReverseInteger {

  public class Solution {
    public int reverse(int x) {
          // Note: The Solution object is instantiated only once and is reused by each test case.
      if (x == Integer.MIN_VALUE) {
        return 0;
      }
      
      int res = 0;
      int sign = x > 0? 1 : -1;
      x = Math.abs(x);
      while (x > 0) {
        int digit = x % 10;
        if (sign == 1 && (Integer.MAX_VALUE - digit) / 10 < res) {
          return 0; // overflow
        }
        else if (sign == -1 && (Integer.MIN_VALUE + digit) / 10 > res) {
          return 0; // underflow
        }
        x /= 10;
        res = res * 10 + sign * digit;
      }
      return res;
    }
  }
  
}
