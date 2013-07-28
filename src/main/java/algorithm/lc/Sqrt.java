package algorithm.lc;

/**
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 * 
 */
public class Sqrt {

  public class Solution {
    // use Newton method
    public int sqrt(int x) {
      // Start typing your Java solution below
      // DO NOT write main() function
      return x == 0 ? 0 : sqrtD(x);
    }

    private int sqrtD(double x) {
      double a = 1;
      while (!isCloseEnough(x, a)) {
        a = (x / a + a) / 2;
      }
      return (int) a;
    }

    private boolean isCloseEnough(double x, double a) {
      if (Math.abs(x - a * a) < 1) {
        return true;
      } else {
        return false;
      }
    }
  }

}
