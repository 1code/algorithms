package algorithm.lc;

/**
 * Implement pow(x, n)
 * 
 */
public class Pow {

  // O(1) space, O(logn) time, if length of number is fixed, it is constant
  // running time
  public class Solution {
    public double pow(double x, int n) {
      // Start typing your Java solution below
      // DO NOT write main() function
      if (n == Integer.MIN_VALUE) {
        return Math.abs(x) == 1? 1 : 0;
      }
      boolean isPositive = n > 0;
      n = Math.abs(n);
      // right shift index each time
      double res = 1;
      double tmp = x;
      while (n > 0) {
        if (n % 2 == 1) {
          res *= tmp;
        }
        tmp *= tmp;
        n >>= 1;
      }
      return isPositive ? res : 1.0 / res;
    }
  }

  // O(1) space, O(logn) time
  public class Solution2 {
    // recursive x^n = x^(n / 2) * x^(n / 2) * x^(n % 2)
    public double pow(double x, int n) {
      // Start typing your Java solution below
      // DO NOT write main() function
      if (n == 0) {
        return 1;
      }
      else if (n == Integer.MIN_VALUE) {
        return Math.abs(x) == 1? 1 : 0;
      }
      
      boolean isPositive = n > 0;
      n = Math.abs(n);
      double res = pow(x, n / 2);
      res *= res * (n % 2 == 0 ? 1 : x);
      return isPositive ? res : 1.0 / res;
    }
  }
}
