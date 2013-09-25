package algorithm.lc;

/**
 * Given a string S and a string T, count the number of distinct subsequences of
 * T in S.
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ACE" is a
 * subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example: S = "rabbbit", T = "rabbit"
 * 
 * Return 3.
 * 
 */
public class DistinctSubsequences {

  public class Solution {
    // use 2D DP, 
    //           /  res[i][j - 1]   , if S.charAt(i - 1) == T.charAt(j - 1)
    // res[i][j]  
    //           \  res[i][j - 1] + res[i - 1][j - 1], if S.charAt(i - 1) != T.charAt(j - 1)
    public int numDistinct(String S, String T) {
      // Start typing your Java solution below
      // DO NOT write main() function
      if (S == null || T == null || T.length() > S.length()) {
        return 0;
      }
      
      int[][] res = new int[T.length() + 1][S.length() + 1];
      for (int i = 0; i <= S.length(); ++i) {
        res[0][i] = 1;
      }
      for (int i = 1; i <= T.length(); ++i) {
        res[i][0] = 0;
      }
      
      for (int i = 1; i <= T.length(); ++i) {
        for (int j = i; j <= S.length(); ++j) {
          if (T.charAt(i - 1) == S.charAt(j - 1)) {
            res[i][j] = res[i][j - 1] + res[i - 1][j - 1];
          }
          else {
            res[i][j] = res[i][j - 1];
          }
        }
      }
      return res[T.length()][S.length()];
    }
  }

}