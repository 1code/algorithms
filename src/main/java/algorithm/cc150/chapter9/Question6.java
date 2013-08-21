package algorithm.cc150.chapter9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Implement an algorithm to print all valid (e.g., properly opened and closed)
 * combinations of n-pairs of parentheses.
 */
// O(n^2) space, O(n^2) time 
public class Question6 {

  // available at leetcode.com online judge, question Generate Parentheses
  public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
          // Start typing your Java solution below
          // DO NOT write main() function
      Set<String> set = new HashSet<String>();
      Queue<String> queue = new LinkedList<String>();
      queue.add("");
      while (!queue.isEmpty()) {
        String seed = queue.poll();
        if (seed.length() == n * 2 - 2) {
          set.addAll(generate(seed));
        }
        else {
          for (String str : generate(seed)){
            queue.add(str);
          }
        }
      }
      return new ArrayList<String>(set);
    }

    private Collection<String> generate(String seed) {
      List<String> list = new ArrayList<String>();
      for (int i = 0; i <= seed.length() / 2; ++i) {
        StringBuilder sb = new StringBuilder(seed);
        sb.insert(i, "()");
        list.add(sb.toString());
      }
      return list;
    }      
  }
}