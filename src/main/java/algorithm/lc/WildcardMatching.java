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
  public static class SolutionDP {
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
            match[i][j] = match[i][j - 1] // * matches empty
                || match[i - 1][j - 1]; // * matches current
                //|| match[i - 1][j]; // * matches previous and current
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
  public static class SolutionDPSlidingWindow {
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

  static class Solution { 
    public boolean isMatch(String s, String p) { 
          // Start typing your Java solution below 
          // DO NOT write main() function 
      int ps = 0, pp = 0, oldPs = 0, oldPp = 0;
      int slen = s.length(), plen = p.length();
      boolean metStar = false;
      
      while (true) {
        if (ps == slen) { // string to the end
          while (pp < plen) { // check if all star in remaining pattern
            if (p.charAt(pp) != '*') {
              return false;
            }
            ++pp;
          }
          return true;
        }
        
        if (pp < plen && (s.charAt(ps) == p.charAt(pp) || p.charAt(pp) == '?')) { // pattern has more and match
          ++pp;
          ++ps;
        }
        else if (pp < plen && p.charAt(pp) == '*') { // pattern has more and attempt to use *
          oldPs = ps;
          oldPp = pp;
          metStar = true;
          ++pp; // use * to match nothing
        }
        else { // no more pattern
          if (metStar) { // restore from previous 
            ++oldPs; // use previous star to match previous character
            ps = oldPs;
            pp = oldPp;
            ++pp;
          }
          else {
            return false;
          }
        }
      }
      
    } 
  };
  
  public static void main(String[] args) {
    String s = "abcsda";
    String p = "??*d?";
    
    SolutionDP sol = new SolutionDP();
    System.out.println(sol.isMatch(s, p));
  }

}
