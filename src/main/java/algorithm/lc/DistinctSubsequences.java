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
    //           /  res[i][j - 1]   , if S.charAt(i - 1) != T.charAt(j - 1)
    // res[i][j]  
    //           \  res[i][j - 1] + res[i - 1][j - 1], if S.charAt(i - 1) == T.charAt(j - 1)
    public int numDistinct(String S, String T) {
      // IMPORTANT: Please reset any member data you declared, as
      // the same Solution instance will be reused for each test case.
      if (T == null || S == null || T.length() > S.length()) {
        return 0;
      }

      int[][] distinct = new int[T.length() + 1][S.length() + 1];

      for (int i = 0; i < distinct.length; ++i) {
        for (int j = i; j < distinct[i].length; ++j) {
          if (i == 0 && j == 0) {
            distinct[i][j] = 1;
          } else if (i == 0) {
            distinct[i][j] = distinct[i][j - 1];
          } else {
            distinct[i][j] = distinct[i][j - 1];
            if (T.charAt(i - 1) == S.charAt(j - 1)) {
              distinct[i][j] += distinct[i - 1][j - 1];
            }
          }
        }
      }

      return distinct[T.length()][S.length()];
    }
  }

}