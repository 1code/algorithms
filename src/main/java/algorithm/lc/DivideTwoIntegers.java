package algorithm.lc;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * 
 */
// O(1) space, O(lgn) time
public class DivideTwoIntegers {

  public class Solution {
    // use right shift operation
    public int divide(int dividend, int divisor) {
          // Start typing your Java solution below
          // DO NOT write main() function
          
      int sign = (dividend < 0) != (divisor < 0)? -1 : 1;
      if (divisor == 0) {
        return 0;
      }
      if (divisor == Integer.MIN_VALUE) {
        return dividend == Integer.MIN_VALUE ? 1 : 0;
      }
      if (dividend == Integer.MIN_VALUE) {
        return sign + divide(dividend - (sign > 0? divisor : -divisor), divisor);
      }
      dividend = Math.abs(dividend);
      divisor = Math.abs(divisor);
      
      int res = 0;
      
      while (dividend >= divisor) {
        int tmp = 1;
        int product = divisor;
        while (dividend - product >= product) {
          product <<= 1;
          tmp <<= 1;
        }
        res += tmp;
        dividend -= product;
      }
      
      return sign > 0 ? res : -res;
    }
  }

}
