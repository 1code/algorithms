package algorithm.lc;

/**
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given an encoded message containing digits,
 * determine the total number of ways to decode it.
 * 
 * For example, Given encoded message "12", it could be decoded as "AB" (1 2) or
 * "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 * 
 */
// O(n) space, O(n) time
public class DecodeWays {

  public class Solution {
    // Use 1-d DP
    public int numDecodings(String s) {
      // Start typing your Java solution below
      // DO NOT write main() function
      if (s == null || s.length() == 0) {
        return 0;
      }
      int[] ways = new int[s.length() + 1];
      ways[0] = 1;
      int prev = 0;
      for (int i = 1; i <= s.length(); ++i) {
        int cur = s.charAt(i - 1) - '0';
        int value = prev * 10 + cur;
        if (cur == 0 && (value != 10 && value != 20)) {
          return 0; // invalid code
        }
        if (value == 20 || value == 10) {
          ways[i] = ways[i - 2];
        } else if (10 < value && value <= 26) {
          ways[i] = ways[i - 1] + ways[i - 2];
        } else { // value > 26, can only decode current character
          ways[i] = ways[i - 1];
        }
        prev = cur;
      }

      return ways[s.length()];
    }
  }

}