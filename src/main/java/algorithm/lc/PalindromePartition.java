package algorithm.lc;

import java.util.ArrayList;

/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab", Return
 * 
 * [ ["aa","b"], ["a","a","b"] ]
 * 
 */
public class PalindromePartition {

  // use DFS
  public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
          // Start typing your Java solution below
          // DO NOT write main() function
      ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
      ArrayList<String> cur = new ArrayList<String>();
      int start = 0;
      dfs(s, start, cur, res);
      return res;
    }
    
    private void dfs(String s, int start, ArrayList<String> cur, ArrayList<ArrayList<String>> res) {
      if (start == s.length()) {
        res.add(new ArrayList<String>(cur));
        return;
      }
      
      for (int end = start; end < s.length(); ++end) {
        if (isPalindrome(s, start, end)) {
          cur.add(s.substring(start, end + 1));
          dfs(s, end + 1, cur, res);
          cur.remove(cur.size() - 1);
        }
      }
    }
    
    private boolean isPalindrome(String s, int start, int end) {
      while (start < end) {
        if (s.charAt(start++) != s.charAt(end--)) {
          return false;
        }
      }
      return true;
    } 
  }

}
