package algorithm.lc;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * 
 */
public class DivideTwoIntegers {

  public class Solution {
    public int divide(int dividend, int divisor) {
      // Start typing your Java solution below
      // DO NOT write main() function
      int symbol = (dividend < 0) != (divisor < 0) ? -1 : 1;
      int tmpDividend = Math.abs(dividend);
      int tmpDivisor = Math.abs(divisor);

      // special cases
      if (divisor == 0) // invalid
        return Integer.MAX_VALUE;
      if (divisor == Integer.MIN_VALUE)
        return dividend == Integer.MIN_VALUE ? 1 : 0;
      if (dividend == Integer.MIN_VALUE)
        return symbol * 1 + divide(dividend - symbol * divisor, divisor);

      int result = 0;
      int product = tmpDivisor;
      while (tmpDivisor <= tmpDividend) {
        int tmpResult = 1;
        while (tmpDividend - product >= product) {
          product <<= 1;
          tmpResult <<= 1;
        }
        result += tmpResult;
        tmpDividend -= product;
        product = tmpDivisor;
      }
      return symbol * result;
    }
  }

}
