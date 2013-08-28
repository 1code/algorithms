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
        String sub1 = expand(s, i, i);
        res = res.length() >= sub1.length()? res : sub1;
        if (i < s.length() - 1) {
          String sub2 = expand(s, i, i + 1);
          res = res.length() >= sub2.length()? res : sub2;
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
