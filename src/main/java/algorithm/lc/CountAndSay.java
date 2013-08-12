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

  public class Solution {
    public String countAndSay(int n) {
          // Start typing your Java solution below
          // DO NOT write main() function
      String str = "1";
      for (int i = 1; i < n; ++i) {
        str = say(str);  
      }     
      
      return str;
    }
    
    private String say(String str) {
      StringBuilder sb = new StringBuilder();
      char last = ' ';
      int count = 0;
      for (int i = 0; i < str.length(); ++i) {
        char ch = str.charAt(i);
        if (ch != last) {
          if (last != ' ') {
            sb.append(count);
            sb.append(last);
          }
          count = 1;
          last = ch;
        }
        else {
          ++count;
        }
      }
      
      if (count != 0) {
        sb.append(count);
        sb.append(last);
      }
      return sb.toString();
    }
  }
  
}
