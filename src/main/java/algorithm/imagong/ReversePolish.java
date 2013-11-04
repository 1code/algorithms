package algorithm.imagong;

import java.util.Stack;

/**
 * The classic reverse polish notation. 
 *
 */
public class ReversePolish {
  
  /**
   *  O(n) time, O(n) space
   *
   */
  public static class Solution{
    double calculateRPNotation(char[] input) {
      Stack<Double> stack = new Stack<Double>();
      
      for (char ch : input) {
        if (Character.isLetterOrDigit(ch)) {
          stack.push((double)(ch - '0'));
        }
        else {
          double second = stack.pop();
          double first = stack.pop();
          if (ch == '+') {
            stack.push(first + second);
          }
          else if (ch == '-') {
            stack.push(first - second);
          }
          else if (ch == '*') {
            stack.push(first * second);
          }
          else if (ch == '/') {
            stack.push(first / second);
          }
          else {
            return -1;
          }
        }
      }
      
      return stack.pop();
    }
  }

}
