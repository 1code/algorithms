package algorithm.lc;

/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * For example, given s = "aab", Return 1 since the palindrome partitioning
 * ["aa","b"] could be produced using 1 cut.
 * 
 */
public class PalindromePartitionII {

  // DP, res[i] records the min cuts between i and n
  // also the palindrome isPalindrome is used to keep track that whether s[i..j] is palindrome
  public class Solution {
    public int minCut(String s) {
      // Start typing your C/C++ solution below
      // DO NOT write int main() function
      int n = s.length();
      int[] res = new int[n + 1]; // keep min cut from i to n
      for (int i = 0; i < res.length; ++i) {
        res[i] = i - 1;
      }
      boolean[][] isPalindrome = new boolean[n][n];
      for (int i = 0; i < n; ++i) {
        for (int j = 0; j <= i; ++j) {
          if (s.charAt(i) == s.charAt(j)
              && (i - j < 2 || isPalindrome[j + 1][i - 1])) { // s[1-j] is
                                                              // palindrome
            isPalindrome[j][i] = true;
            res[i + 1] = Math.min(res[i + 1], res[j] + 1);
          }
        }
      }
      return res[n];
    }
  };

}
