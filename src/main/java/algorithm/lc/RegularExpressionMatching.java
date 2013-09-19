package algorithm.lc;

public class RegularExpressionMatching {

  public class Solution {
    // O(mn) space, O(mn) time
    // 2D DP
    public boolean isMatch(String s, String p) {
      // Start typing your Java solution below
      // DO NOT write main() function
      int m = s.length(), n = p.length();
      boolean[][] match = new boolean[m + 1][n + 1];
      match[0][0] = true;
      for (int j = 1; j < n + 1; j++) {
        if (p.charAt(j - 1) == '*') {
          match[0][j] = match[0][j - 2]; // if current is *
        } 
      }

      for (int i = 1; i < m + 1; i++) {
        for (int j = 1; j < n + 1; j++) {
          if (p.charAt(j - 1) != '*') {
            match[i][j] = match[i - 1][j - 1] // prefix is matching
                && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
          }
          else { // pattern is *
            match[i][j] = match[i][j - 2]; // if current * does not generate any character
            if (p.charAt(j - 2) == '.' // if current is .*
                || s.charAt(i - 1) == p.charAt(j - 2)) { // if pattern has the same character as current character
              match[i][j] |= match[i - 1][j];
            }
          }
        }
      }

      return match[m][n];
    }
  }

}
