package algorithm.lc;

/**
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 * 
 */
public class Sqrt {

  // Netwon method
  public class Solution {
    public int sqrt(int x) {
          // Start typing your Java solution below
          // DO NOT write main() function
      double guess = 1;
      while (!closeEnough(guess, x)) {
        guess = (x / guess + guess) / 2;
      }
      return (int)guess;
    }
    
    private boolean closeEnough(double guess, int x) {
      if (Math.abs(guess * guess - x) < 0.1) {
        return true;
      }
      return false;
    }
  }

}
