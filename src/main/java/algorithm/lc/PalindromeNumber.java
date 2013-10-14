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
        if (x / digit != x % 10) {
          return false;
        }
        x -= x % 10 * digit; // remove highest digit
        x /= 10; // remove lowest digit
        digit /= 100;
      }
      return true;
    }
  }

}
