package algorithm.lc;

/**
 * Write a function to find the longest common prefix string amongst an array of strings. 
 *
 */
//O(d) space, O(nd) time, where d is the length of the shortest string
public class LongestCommonPrefix {
  
  public class Solution {
    public String longestCommonPrefix(String[] strs) {
          // Start typing your Java solution below
          // DO NOT write main() function
      
      // find shortes one
      String shortest = "";
      int minLen = Integer.MAX_VALUE;
      for (String str : strs) {
        int curLen = str.length();
        if (curLen < minLen) {
          minLen = curLen;
          shortest = str;
        }
      }    
      
      // find longest prefix
      for (int i = 0; i < shortest.length(); ++i) {
        char curCh = shortest.charAt(i);
        for (String str : strs) {
          if (str.charAt(i) != curCh) {
            return shortest.substring(0, i);
          }
        }
      }
          
      return shortest;
    }
  }

}
