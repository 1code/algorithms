package algorithm.lc;

import java.util.HashMap;
import java.util.Map;

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
      Map<Character, Integer> map = new HashMap<Character, Integer>();
      int maxLen = 0;
      int start = 0, end = 0;
      while (end < s.length()) {
        char ch = s.charAt(end);
        Integer pos = map.get(ch);
        if (pos != null && pos >= start) { // duplicate
          start = pos + 1;
        } else {
          maxLen = Math.max(maxLen, end - start + 1);
        }
        map.put(ch, end); // update map
        ++end;
      }
      return maxLen;
    }
  }

}
