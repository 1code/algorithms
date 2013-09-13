package algorithm.lc;

public class WildcardMatching {
  
  // O(1) space, O(2^n) time
  public class SolutionRecursive {
    public boolean isMatch(String s, String p) {
          // Start typing your Java solution below
          // DO NOT write main() function
      if (p.length() == 0) {
        return s.length() == 0;
      }      
      if (s.length() == 0) {
        return allStar(p);
      }
      
      if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?') {
        return isMatch(s.substring(1), p.substring(1));
      }
      else if (p.charAt(0) == '*') {
        return isMatch(s.substring(1), p) || isMatch(s, p.substring(1));
      }
      
      return false;
    }
    
    private boolean allStar(String p) {
      for (char c : p.toCharArray()) {
        if (c != '*') {
          return false;
        }
      }
      return true;
    }
  }
  
  public static class Solution {
    public boolean isMatch(String s, String p) {
          // Start typing your Java solution below
          // DO NOT write main() function
      if (s == null || p == null) {
        return false;
      }
      
      int m = s.length(), n = p.length();
      boolean[][] match = new boolean[m + 1][n + 1];
      match[0][0] = true;
      for (int i = 1; i < n + 1; ++i) {
        if (p.charAt(i - 1) == '*') {
          match[0][i] = match[0][i - 1];
        }
      }
      
      for (int i = 1; i < m + 1; ++i) {
        for (int j = 1; j < n + 1; ++j) {
          if (p.charAt(j - 1) == '*') {
            match[i][j] = match[i][j - 1] // current * matches empty
                || match[i - 1][j - 1] // current * matches current
                || match[i - 1][j];
          }
          else if (p.charAt(j - 1) == '?') {
            match[i][j] = match[i - 1][j - 1];
          }
          else {  // specific character
            match[i][j] = match[i - 1][j - 1] && s.charAt(i - 1) == p.charAt(j - 1);
          }
        }
      }
      
      return match[m][n];
    }
  }
  
  public static void main(String[] args) {
    String[][] test = {
        {"aba", "*b?", "true"},
        {"a", "a*", "true"},
        {"a", "?", "true"},
        {"a", "*", "true"}, 
        {"b", "a", "false"},
        {"aa", "a*a*", "true"},
        {"aaaa", "a*a", "true"},
        {"aaaaa", "a*a", "true"},
        {"aaaaaa", "a*a", "true"},
        {"aaaaaaaaabbbbbba", "a*a", "true"},
        {"abdadtasddtasdtadfasdt", "*b*t*?s*", "true"}
    };
    Solution sol = new Solution();
    for (String[] s : test) {
      if (Boolean.parseBoolean(s[2]) != sol.isMatch(s[0], s[1])) {
        System.out.printf("%s\t%s: %s\n", s[0], s[1], s[2]);
      }
    }
  }

}
