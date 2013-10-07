package algorithm.lc;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * 
 */
// O(1) space, O(lgn) time
public class DivideTwoIntegers {

  // O(1) space, O(lgn) time
  public class Solution {
    public int divide(int dividend, int divisor) {
          // Start typing your Java solution below
          // DO NOT write main() function
      if (divisor == 0) {
        return 0;
      }
      int sign = (dividend > 0 != divisor > 0)? -1 : 1;
      if (divisor == Integer.MIN_VALUE) {
        return dividend == Integer.MIN_VALUE? 1 : 0;
      } 
      if (dividend == Integer.MIN_VALUE) {
        return sign + divide(dividend - (divisor < 0? divisor : -divisor), divisor);
      }
      dividend = Math.abs(dividend);
      divisor = Math.abs(divisor);
      
      int res = 0;
      while (dividend >= divisor) {
        int pow = 1;
        int product = divisor;
        while (dividend - product >= product) {
          product <<= 1;
          pow <<= 1;
        }
        res += pow;
        dividend -= product;
      }
      return sign * res;
    }
  }

}
