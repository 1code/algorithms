package algorithm.lc;

import java.util.Arrays;

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
      } else if (p.charAt(0) == '*') {
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

  // O(mn) space, O(mn) time
  public class SolutionDP {
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
                || match[i - 1][j]; // current * matches previous and current
                                    // characters
          } else if (p.charAt(j - 1) == '?') {
            match[i][j] = match[i - 1][j - 1]; // matches any single character
          } else { // specific character
            match[i][j] = match[i - 1][j - 1]
                && s.charAt(i - 1) == p.charAt(j - 1);
          }
        }
      }

      return match[m][n];
    }
  }

  // O(n) space, O(mn) time
  // use 2D DP + Sliding Window
  public class SolutionDPSlidingWindow {
    public boolean isMatch(String s, String p) {
      // Start typing your Java solution below
      // DO NOT write main() function
      if (s == null || p == null) {
        return false;
      }

      int m = s.length(), n = p.length();
      boolean[][] buf = new boolean[2][n + 1];
      boolean[] prev = buf[0];
      boolean[] cur = buf[1];
      prev[0] = true;
      for (int i = 1; i < n + 1; ++i) {
        if (p.charAt(i - 1) == '*') {
          prev[i] = prev[i - 1];
        }
      }

      for (int i = 1; i < m + 1; ++i) {
        prev = buf[(i + 1) % 2];
        cur = buf[i % 2];
        Arrays.fill(cur, false); // reset
        for (int j = 1; j < n + 1; ++j) {
          if (p.charAt(j - 1) == '*') {
            cur[j] = cur[j - 1] // current * matches empty
                || prev[j - 1] // current * matches current
                || prev[j]; // current *
          } else if (p.charAt(j - 1) == '?') {
            cur[j] = prev[j - 1];
          } else { // specific character
            cur[j] = prev[j - 1] && s.charAt(i - 1) == p.charAt(j - 1);
          }
        }
      }

      return buf[m % 2][n];
    }
  }

  public static class Solution {
    public boolean isMatch(String s, String p) {
      int is = 0, ip = 0, is0 = 0, ip0 = 0;
      int lens = s.length(), lenp = p.length();
      boolean metStar = false;

      while (true) {
        if (is == lens) {
          while (ip < lenp && p.charAt(ip) == '*') {// only * left in p
            ++ip;
          }
          return ip == lenp;
        }
        if (ip < lenp && (p.charAt(ip) == '?' || p.charAt(ip) == s.charAt(is))) {
          ++ip;
          ++is;
        } else if (ip < lenp && p.charAt(ip) == '*') { // attempt to use * to match empty
          is0 = is;
          ip0 = ip;
          metStar = true;
          ++ip;
        } else {
          if (metStar) { // use star to match current character
            ++is0;
            is = is0;
            ip = ip0;
            ++ip;
          } else {
            return false;
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    String[][] test = { { "aba", "*b?", "true" }, { "a", "a*", "true" },
        { "a", "?", "true" }, { "a", "*", "true" }, { "b", "a", "false" },
        { "aa", "a*a*", "true" }, { "aaaa", "a*a", "true" },
        { "aaaaa", "a*a", "true" }, { "aaaaaa", "a*a", "true" },
        { "aaaaaaaaabbbbbba", "a*a", "true" },
        { "abdadtasddtasdtadfasdt", "*b*t*?s*", "true" },
        { "aaaaddddb", "?????????", "true" }, { "fasdflkjasd", "*", "true" },
        { "asdflewlrjks", "***", "true" } };
    Solution sol = new Solution();
    for (int i = 0; i < test.length; ++i) {
      String[] s = test[i];
      if (Boolean.parseBoolean(s[2]) != sol.isMatch(s[0], s[1])) {
        System.out.printf("%d\t%s\t%s: %s\n", i, s[0], s[1], s[2]);
      }
    }
  }

}
