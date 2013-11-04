package algorithm.imagong;

import java.util.Stack;

public class GenerateReversePolish {
  
  /**
   * O(n) space, O(n) time 
   *
   */
  public static class Solution{
    String genRPNotation(char[] input) {
    
      StringBuilder sb = new StringBuilder();
      Stack<Character> stack = new Stack<Character>();
      
      for (int i = 0; i < input.length; ++i) {
        if (Character.isLetterOrDigit(input[i])) {
          sb.append(input[i]);
        }
        else if (input[i] == ')') { // pop until '(' is popped
          while (!stack.isEmpty()) {
            char cur = stack.pop();
            if (cur == '(') {
              break;
            }
            sb.append(cur);
          }
        }
        else if (input[i] == '+' || input[i] == '-') { // pop until the top has no high priority than current
          while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
            sb.append(stack.pop());
          }
          stack.push(input[i]);
        }
        else if (input[i] == '*' || input[i] == '/' || input[i] == '(') {
          stack.push(input[i]);
        }
      }
      
      while (!stack.isEmpty()) {
        sb.append(stack.pop());
      }
      
      return sb.toString();
    }
  }

}
