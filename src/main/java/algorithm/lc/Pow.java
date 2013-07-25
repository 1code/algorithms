package algorithm.lc;

/**
 * Implement pow(x, n)
 * 
 */
// O(1) space, O(logn) time
public class Pow {

  public class Solution {
    public double pow(double x, int n) {
          // Start typing your Java solution below
          // DO NOT write main() function
      int sign = 1;
      if (n < 0) {
        sign = -1;
        n = -n;
      }
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
      
      return sign == -1? 1.0 / res : res;
    }
  }
}
