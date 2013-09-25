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
      StringBuilder sb = new StringBuilder();
      int leftParen = n;
      int rightParen = n;
      generate(leftParen, rightParen, sb, res);
      return res;
    }
    
    private void generate(int leftParen, int rightParen, StringBuilder sb, ArrayList<String> res) {
      if (leftParen == 0 && rightParen == 0) {  // used up parenthesis
        res.add(sb.toString());
      }   
      if (leftParen > 0) {
        sb.append("(");
        generate(leftParen - 1, rightParen, sb, res);
        sb.deleteCharAt(sb.length() - 1);
      }
      if (rightParen > leftParen) {
        sb.append(")");
        generate(leftParen, rightParen -1, sb, res);
        sb.deleteCharAt(sb.length() - 1);
      }
    }
  }

}
