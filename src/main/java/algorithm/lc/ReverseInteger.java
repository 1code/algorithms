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
      // Start typing your Java solution below
      // DO NOT write main() function
      int sign = x >> 31 == 0 ? 1 : x >> 31; // get the sign
      x = sign * x; // remove the sign
      int y = 0;
      while (x > 0) {
        y = y * 10 + x % 10;
        x /= 10;
      }

      return sign * y;
    }
  }

}
