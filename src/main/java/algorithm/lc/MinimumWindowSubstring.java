package algorithm.lc;

/**
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * For example, S = "ADOBECODEBANC" T = "ABC"
 * 
 * Minimum window is "BANC".
 * 
 * Note: If there is no such window in S that covers all characters in T, return
 * the emtpy string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always
 * be only one unique minimum window in S.
 * 
 */
// O(1) space, O(n) time
public class MinimumWindowSubstring {
  public class Solution {
    // two pointers, move forward end and shrink start if possible
    public String minWindow(String S, String T) {
          // Start typing your Java solution below
          // DO NOT write main() function
      int[] has = new int[256];
      int[] needs = new int[256];
      
      for (int i = 0; i < T.length(); ++i) {
        ++needs[(int)T.charAt(i)];
      }
      
      int min = Integer.MAX_VALUE;
      int acc = 0;
      int minStart = -1;
      int minEnd = -1;
      for (int start = 0, end = 0; end < S.length(); ++end) {
        int cur = (int)S.charAt(end);
        if (needs[cur] == 0) {
          continue; // skip useless character
        }
        ++has[cur];
        if (has[cur] <= needs[cur]) {
          ++acc;
        }
        if (acc == T.length()) { // shrink 
          while (needs[(int)S.charAt(start)] == 0 || has[(int)S.charAt(start)] > needs[(int)S.charAt(start)]) {
            if (has[(int)S.charAt(start)] > needs[(int)S.charAt(start)]) {
              --has[(int)S.charAt(start)];
            }
            ++start;
          }
          int len = end - start + 1;
          if (len < min) {
            min = len;
            minStart = start;
            minEnd = end;
          }
        }
      }
      
      if (minStart == -1) {
        return "";
      }
      
      return S.substring(minStart, minEnd + 1);
    }
  }
}
