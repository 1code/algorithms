package algorithm.lc;

/**
 * Given a string S, find the longest palindromic substring in S. You may assume
 * that the maximum length of S is 1000, and there exists one unique longest
 * palindromic substring.
 * 
 */
// O(1) space, O(n^2) time
public class LongestPalindromeSubstring {

  public class Solution {
    // expand from each of the 2N - 1 centers
    public String longestPalindrome(String s) {
      // Start typing your Java solution below
      // DO NOT write main() function
      String longest = "";
      if (s.length() == 0) {
        return longest;
      }

      for (int i = 0; i < s.length() - 1; ++i) {
        String str1 = expand(s, i, i);
        if (str1.length() > longest.length()) {
          longest = str1;
        }
        String str2 = expand(s, i, i + 1); // center lies between characters
        if (str2.length() > longest.length()) {
          longest = str2;
        }
      }
      return longest;
    }

    private String expand(String s, int i, int j) {
      while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
        --i;
        ++j;
      }
      return s.substring(i + 1, j);
    }
  }
  
}
