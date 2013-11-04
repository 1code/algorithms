package algorithm.lc;

import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example, path = "/home/", => "/home" path = "/a/./b/../../c/", => "/c"
 * 
 * Corner Cases: Did you consider the case where path = "/../"? In this case,
 * you should return "/". Another corner case is the path might contain multiple
 * slashes '/' together, such as "/home//foo/". In this case, you should ignore
 * redundant slashes and return "/home/foo".
 * 
 */
public class SimplifyPath {

  /**
   * O(n) space, O(n) time.
   * 
   */
  public class Solution {
    public String simplifyPath(String path) {
      // IMPORTANT: Please reset any member data you declared, as
      // the same Solution instance will be reused for each test case.
      if (path == null) {
        return "/";
      }
      Stack<String> stack = new Stack<String>();
      String[] tokens = path.split("/");
      for (String token : tokens) {
        if (token.equals(".") || token.length() == 0) {
          // ignore
        } else if (token.equals("..")) {
          if (!stack.isEmpty()) {
            stack.pop();
          }
        } else {
          stack.push(token);
        }
      }

      if (stack.isEmpty()) {
        return "/";
      }

      StringBuilder sb = new StringBuilder();

      while (!stack.isEmpty()) {
        sb.insert(0, stack.pop());
        sb.insert(0, '/');
      }
      return sb.toString();
    }
  }

}
