package algorithm.lc;

/**
 * Implement pow(x, n)
 * 
 */
public class Pow {

  //O(1) space, O(logn) time, if length of number is fixed, it is constant running time
  public class Solution {
    public double pow(double x, int n) {
          // Start typing your Java solution below
          // DO NOT write main() function
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
      return isPositive? 1.0 / res : res;
    }
  }
  
  // O(1) space, O(logn) time
  public class Solution2 {
    public double pow(double x, int n) {
          // Start typing your Java solution below
          // DO NOT write main() function
      boolean isPositive = n > 0;
      n = Math.abs(n);
      double res = getPow(x, n);
      return isPositive? res : 1.0 / res;
    }
    
    private double getPow(double x, int n) {
      if (n == 0) {
        return 1;
      }
      double half = getPow(x, n / 2);
      double res = half * half * (n % 2 == 0? 1 : x);
      return res;
    }
  }
}
