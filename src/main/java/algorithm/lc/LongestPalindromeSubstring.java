package algorithm.lc;

/**
 * Given a string S, find the longest palindromic substring in S. You may assume
 * that the maximum length of S is 1000, and there exists one unique longest
 * palindromic substring.
 * 
 */
public class LongestPalindromeSubstring {

  public class Solution {
    // O(1) space, O(n^2) time
    // expand from each of the 2N - 1 centers
    public String longestPalindrome(String s) {
          // Start typing your Java solution below
          // DO NOT write main() function
      String res = "";
      for (int i = 0; i < s.length(); ++i) {
        String palindrome1 = expand(s, i, i); // center is between two characters
        res = res.length() >= palindrome1.length()? res : palindrome1;
        if (i < s.length() - 1) {
          String palindrome2 = expand(s, i, i + 1); // center is the middle two characters
          res = res.length() >= palindrome2.length()? res : palindrome2;
        }
      }
      return res;
    }
    
    private String expand(String s, int start, int end) {
      while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
        --start;
        ++end;
      }
      return s.substring(start + 1, end);
    }
  }
  
}
