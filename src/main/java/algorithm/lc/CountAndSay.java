package algorithm.lc;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read
 * off as "one 2, then one 1" or 1211.
 * 
 * Given an integer n, generate the nth sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 * 
 */
public class CountAndSay {

  // O(nm) space, O(nm) time
  public class Solution {
    public String countAndSay(int n) {
          // Start typing your Java solution below
          // DO NOT write main() function
      StringBuilder sb = new StringBuilder();
      sb.append(1);
      for (int i = 0; i < n - 1; ++i) {
        StringBuilder newSb = new StringBuilder();
        int c = 1;
        for (int j = 0; j < sb.length() - 1; ++j) {
          if (sb.charAt(j) == sb.charAt(j + 1)) {
            ++c;
          }
          else {
            newSb.append(c);
            newSb.append(sb.charAt(j));
            c = 1;
          }
        }
        // add the last one
        newSb.append(c);
        newSb.append(sb.charAt(sb.length() - 1));
        sb = newSb;
      }
      return sb.toString();
    }
  }
  
}