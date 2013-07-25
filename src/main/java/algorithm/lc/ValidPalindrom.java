package algorithm.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car"
 * is not a palindrome.
 * 
 * Note: Have you consider that the string might be empty? This is a good
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 
 */
public class ValidPalindrom {

  public class Solution {
    public boolean isPalindrome(String s) {
      // Start typing your Java solution below
      // DO NOT write main() function
      int left = 0;
      int right = s.length() - 1;
      while (left < right) {
        while (left <= right && !Character.isLetterOrDigit(Character.toLowerCase(s.charAt(left)))) {
          ++left;
        }
        while (left <= right && !Character.isLetterOrDigit(Character.toLowerCase(s.charAt(right)))) {
          --right;
        }

        if (left < right
            && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s
                .charAt(right))) {
          return false;
        } 
        else {
          ++left;
          --right;
        }

      }

      return true;
    }
  }

}
