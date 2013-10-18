package algorithm.lc;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 * 
 */
// O(n) space, O(n) time
public class ValidParenthesis {

  public class Solution {
    // match current char with the one in the stack top
    public boolean isValid(String s) {
      // Start typing your Java solution below
      // DO NOT write main() function
      if (s == null || s.length() == 0) {
        return true;
      }

      char[] stack = new char[s.length()];
      int top = -1;

      for (int i = 0; i < s.length(); ++i) {
        char ch = s.charAt(i);
        if (ch == '(' || ch == '[' || ch == '{') {
          stack[++top] = ch;
        } else { // assume s only contains parenthesis
          if (top < 0) {
            return false;
          }
          char prev = stack[top];
          if (prev == '(' && ch != ')' || prev == '[' && ch != ']'
              || prev == '{' && ch != '}') {
            return false;
          } else { // pop
            --top;
          }
        }
      }
      if (top == -1) {
        return true;
      }
      return false;
    }
  }

}
