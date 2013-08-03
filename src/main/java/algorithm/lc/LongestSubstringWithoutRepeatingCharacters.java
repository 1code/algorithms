package algorithm.lc;

import java.util.Map;
import java.util.TreeMap;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters. For example, the longest substring without repeating letters for
 * "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring
 * is "b", with the length of 1.
 * 
 */
// O(n) space, O(nlgn) time
public class LongestSubstringWithoutRepeatingCharacters {

  public class Solution {
    // two pointers with an tree map to store all the visited characters
    public int lengthOfLongestSubstring(String s) {
      // Start typing your Java solution below
      // DO NOT write main() function
      int maxLen = 0;
      int start = 0;
      int end = 0;
      Map<Character, Integer> index = new TreeMap<Character, Integer>();
      while (end < s.length()) {
        char ch = s.charAt(end);
        Integer pos = index.get(ch);
        if (pos != null && pos >= start) { // duplicate
          start = index.get(ch) + 1;
        } else {
          maxLen = Math.max(maxLen, end - start + 1); // update length
        }
        index.put(ch, end); // update index;
        ++end;
      }
      return maxLen;
    }
  }

}
