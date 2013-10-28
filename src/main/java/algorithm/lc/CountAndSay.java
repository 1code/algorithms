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
  
  public static class Solution2 {
    public String countAndSay(int n) {
          // IMPORTANT: Please reset any member data you declared, as
          // the same Solution instance will be reused for each test case.
      StringBuilder seq = new StringBuilder();
      seq.append(1);
      for (int i = 1; i < n; ++i) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char prevChar = seq.charAt(0);
        for (int j = 1; j < seq.length(); ++j) {
          if (seq.charAt(j) == prevChar) {
            ++count;
          }
          else {
            sb.append(count);
            sb.append(prevChar);
            count = 1;
            prevChar = seq.charAt(j);
          }
        }
        seq.append(count);
        seq.append(prevChar);
        seq = sb;
      }
      return seq.toString();
    }
    
  }
  
  public static void main(String[] args) {
    Solution2 solution = new Solution2();
    solution.countAndSay(3);
  }
  
}