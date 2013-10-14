package algorithm.lc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 */
public class GenerateParenthesis {

  public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
      // Start typing your Java solution below
      // DO NOT write main() function
      Set<String> res = new HashSet<String>();
      Queue<String> seeds = new LinkedList<String>();
      seeds.add("");
      while (!seeds.isEmpty()) {
        String seed = seeds.poll();
        for (String newSeed : generate(seed)) {
          if (newSeed.length() == 2 * n) {
            res.add(newSeed);
          } else {
            seeds.offer(newSeed);
          }
        }
      }
      return new ArrayList<String>(res);
    }

    private Set<String> generate(String seed) {
      Set<String> set = new HashSet<String>();
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i <= seed.length() / 2; ++i) {
        sb.append(seed);
        sb.insert(i, "()");
        set.add(sb.toString());
        sb.setLength(0);
      }
      return set;
    }
  }
  
  public class Solution2 {
    public ArrayList<String> generateParenthesis(int n) {
          // Start typing your Java solution below
          // DO NOT write main() function
      ArrayList<String> res = new ArrayList<String>();
      StringBuilder cur = new StringBuilder();
      int leftParen = n;
      int rightParen = n;
      generate(leftParen, rightParen, cur, res);
      return res;
    }
    
    private void generate(int leftParen, int rightParen, StringBuilder cur, ArrayList<String> res) {
      if (leftParen == 0 && rightParen == 0) {  // used up parenthesis
        res.add(cur.toString());
      }   
      if (leftParen > 0) {
        cur.append("(");
        generate(leftParen - 1, rightParen, cur, res);
        cur.deleteCharAt(cur.length() - 1);
      }
      if (rightParen > leftParen) {
        cur.append(")");
        generate(leftParen, rightParen -1, cur, res);
        cur.deleteCharAt(cur.length() - 1);
      }
    }
  }

}
