package algorithm.lc;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * For example, Given s = "Hello World", return 5.
 * 
 */
// O(1) space, O(n) time
public class LengthOfLastWord {
  
  public class Solution {
    public int lengthOfLastWord(String s) {
          // Start typing your Java solution below
          // DO NOT write main() function
      // right trim string
      int last = s.length();
      for (int i = s.length() - 1; i >= 0; --i) {
        if (s.charAt(i) != ' ') {
          break;
        }
        else {
          --last;
        }
      }
      // find the last word
      s = s.substring(0, last);
      for (int i = s.length() - 1; i >= 0; --i) {
        if (s.charAt(i) == ' ') {
          return s.length() - i;  
        }
      }
      return s.length();
    }
  }

}
