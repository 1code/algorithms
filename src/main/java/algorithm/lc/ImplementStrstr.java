package algorithm.lc;

/**
 * Implement strStr().
 * 
 * Returns a pointer to the first occurrence of needle in haystack, or null if
 * needle is not part of haystack.
 * 
 */
public class ImplementStrstr {

  // O(nm) time, brute force
  public class Solution {
    public String strStr(String haystack, String needle) {
      // Start typing your Java solution below
      // DO NOT write main() function
      if (haystack.length() < needle.length()) {
        return "";
      }
      for (int i = 0; i < haystack.length() - needle.length() + 1; ++i) {
        int j = 0;
        for (; j < needle.length(); ++j) {
          if (haystack.charAt(i + j) == needle.charAt(j)) {
            break;
          }
        }
        if (j == needle.length()) {
          return haystack.substring(i);
        }
      }
      return null;
    }
  }

  // O(m) space, O(n + mR) time, where m is the length o needle, n is the length
  // of haystack, and R is the distinct number of characters
  public class SolutionKMP {
    public String strStr(String haystack, String needle) {
      // Start typing your Java solution below
      // DO NOT write main() function
      if (needle.length() == 0) {
        return haystack;
      }
      int[][] dfa = build(needle);
      int j = 0, i = 0;
      for (; i < haystack.length() && j < needle.length(); ++i) {
        j = dfa[haystack.charAt(i)][j];
      }
      if (j == needle.length()) {
        return haystack.substring(i - j);
      } else {
        return null;
      }
    }
    
    private int[][] build(String needle) {
      int R = 256;
      int[][] dfa = new int[R][needle.length()];
      int S = 0;
      dfa[needle.charAt(0)][S] = 1;
      for (int i = 1; i < needle.length(); ++i) {
        for (int c = 0; c < R; ++c) {
          dfa[c][i] = dfa[c][S]; // mismatch transition
        }
        dfa[needle.charAt(i)][i] = i + 1; // update match transition
        S = dfa[needle.charAt(i)][S]; // move to next state
      }
      return dfa;
    }
  }

}
