package algorithm.imagong;

import java.util.Stack;

/**
 * Check whether a string consists only (,[,{,),],} is valid. 
 * e.g. ()[]{} is a valid string, )(][ is not.
 */
public class ValidParenthesis {
  
  /**
   * O(n) time, O(n) space 
   *
   */
  public static class Solution{
    public boolean isBracketValid(String s) {
      Stack<Character> stack = new Stack<Character>();
      for (int i = 0; i < s.length(); ++i) {
        char ch = s.charAt(i);
        if (ch == '(' || ch == '[' || ch == '{') {
          stack.push(ch);
        }
        else {
          if (stack.isEmpty()) {
            return false;
          }
          else if (ch == ')' && stack.peek() != '(' 
            || ch == ']' && stack.peek() != '['
            || ch == '}' && stack.peek() != '{') {
            return false;
          }
          else {
            stack.pop();
          }
        }
      }
      
      return stack.isEmpty();
    }
  }

}
