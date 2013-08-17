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
  class Solution {  
    public int minCut(String s) {  
      // Start typing your C/C++ solution below  
      // DO NOT write int main() function  
      int n = s.length();  
      int[] res = new int[n + 1]; // keep min number of partitions from in range s[i..n]
      for(int i = 0 ; i < res.length; ++i){  
        res[i] = n - i;  
      }  
      boolean[][] isPalindrome = new boolean[n][n];
      for(int i = n - 1; i >= 0; --i){  
        for(int j = i; j < n ; ++j){  
          if(s.charAt(i) == s.charAt(j) && (j - i < 2 || isPalindrome[i + 1][j - 1])){  // s[1-j] is palindrome
            isPalindrome[i][j] = true;  
            res[i] = Math.min(res[i], res[j + 1] + 1);  
          }  
        }  
      }  
      return res[0] - 1;  
    }  
  };  

}
