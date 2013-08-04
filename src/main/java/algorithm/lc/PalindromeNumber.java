package algorithm.lc;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 */
// O(1) space, O(n) time
public class PalindromeNumber {

  public class Solution {
    // compare the highest and lowest each time
    public boolean isPalindrome(int x) {
      // Start typing your Java solution below
      // DO NOT write main() function
      if (x < 0) {
        return false;
      }

      int digit = 1;
      int tmp = x;
      while (tmp >= 10) {
        digit *= 10;
        tmp /= 10;
      }

      while (x >= 10) {
        int low = x % 10;
        int high = x / digit;
        if (low != high) {
          return false;
        }
        x = (x - high * digit) / 10;
        digit /= 100;
      }
      return true;
    }
  }

}
