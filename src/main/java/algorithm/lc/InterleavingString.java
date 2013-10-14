package algorithm.lc;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * For example, Given: s1 = "aabcc", s2 = "dbbca",
 * 
 * When s3 = "aadbbcbcac", return true. When s3 = "aadbbbaccc", return false.
 * 
 */
public class InterleavingString {

  // 2D DP
  // O(mn) space, O(mn) time
  public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
      // Start typing your Java solution below
      // DO NOT write main() function
      if (s3.length() != s1.length() + s2.length()) {
        return false;
      }
      boolean[][] match = new boolean[s1.length() + 1][s2.length() + 1];
      match[0][0] = true;
      int i = 1;
      while (i < s1.length() + 1 && s1.charAt(i - 1) == s3.charAt(i - 1)) {
        match[i][0] = true;
        ++i;
      }

      int j = 1;
      while (j < s2.length() + 1 && s2.charAt(j - 1) == s3.charAt(j - 1)) {
        match[0][j] = true;
        ++j;
      }

      for (i = 1; i < s1.length() + 1; ++i) {
        for (j = 1; j < s2.length() + 1; ++j) {
          char c = s3.charAt(i + j - 1);
          if (c == s1.charAt(i - 1)) { // s1[i] can be used
            match[i][j] |= match[i - 1][j];
          }
          if (c == s2.charAt(j - 1)) { // s2[j] can be used
            match[i][j] |= match[i][j - 1];
          }
        }
      }

      return match[s1.length()][s2.length()];
    }
  }

}
