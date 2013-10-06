package algorithm.lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class WordBreakII {
  
  // O(1) space (cache not used yet), O(2^n) time, Time Limited Exceed
  // Recursive solution
  public static class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
          // Note: The Solution object is instantiated only once and is reused by each test case.
      ArrayList<String> res = new ArrayList<String>();
      Stack<String> cur = new Stack<String>();
      Map<String, Boolean> cache = new HashMap<String, Boolean>();
      found(s, dict, cur, res, cache);
      return res;
    }
    
    private void found(String s, Set<String> dict, Stack<String> cur, ArrayList<String> res, Map<String, Boolean> cache) {
      if (s.length() == 0) { // find a solution
        res.add(concatenate(cur));
        return;
      }
      
      
      
      // check concatenatable
      for (int i = 1; i <= s.length(); ++i) {
        String prefix = s.substring(0, i);
        String suffix = "";
        if (i < s.length()) {
          suffix = s.substring(i);
        }
        
        if (dict.contains(prefix)) { // continue try the remaining part
          cur.push(prefix);
          found(suffix, dict, cur, res, cache);
          cur.pop();
        }
      }
    }
    
    private String concatenate(Stack<String> cur) {
      StringBuilder sb = new StringBuilder();
      if (cur.size() == 0) {
        return sb.toString();
      }
      Iterator<String> itr = cur.iterator();
      sb.append(itr.next());
      while (itr.hasNext()) {
        sb.append(" ");
        sb.append(itr.next());
      }
      return sb.toString();
    }
  }
  
  public static void main(String[] args) {
    Solution sol = new Solution();
    String s = "catsanddog";
    Set<String> dict = new HashSet<String>();
    dict.add("cat");
    dict.add("cats");
    dict.add("and");
    dict.add("sand");
    dict.add("dog");
    
    ArrayList<String> res = sol.wordBreak(s, dict);
    for (String str : res) {
      System.out.println(str);
    }
  }

}
