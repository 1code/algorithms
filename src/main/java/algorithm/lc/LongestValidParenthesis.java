package algorithm.lc;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of
 * the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length
 * = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is
 * "()()", which has length = 4.
 * 
 */
// O(n) space, O(n) time
public class LongestValidParenthesis {

  public class Solution {
    // maintain a stack to records all candidate start position,
    // the top of the stack is the previous possible left bound,
    // the cur start is the possible left most bound
    public int longestValidParentheses(String s) {
      // Start typing your Java solution below
      // DO NOT write main() function
      int start = Integer.MAX_VALUE;
      int maxLen = 0;
      Stack<Integer> leftPos = new Stack<Integer>();
      for (int i = 0; i < s.length(); ++i) {
        char ch = s.charAt(i);
        if (ch == '(') {
          leftPos.push(i); // record candidate start
        } else { // meet ')'
          if (leftPos.isEmpty()) { 
            start = i + 1;  // all previous characters become invalid, start from scratch
          } else {
            start = Math.min(start, leftPos.pop());
            int curLen = 0;
            if (leftPos.isEmpty()) {
              curLen = i - start + 1;
            } else {
              curLen = i - leftPos.peek();
            }
            maxLen = Math.max(maxLen, curLen);
          }
        }
      }
      return maxLen;
    }
  }

}
