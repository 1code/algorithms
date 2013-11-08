package algorithm.lc;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePostorderTraversal {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  /**
   * O(n) time, O(n) space. 
   *
   */
  public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
      // IMPORTANT: Please reset any member data you declared, as
      // the same Solution instance will be reused for each test case.
      ArrayList<Integer> res = new ArrayList<Integer>();
      TreeNode prev = null;
      Stack<TreeNode> stack = new Stack<TreeNode>();
      if (root != null) {
        stack.push(root);
      }
      while (!stack.isEmpty()) {
        TreeNode cur = stack.peek();
        if (prev == null || prev.left == cur || prev.right == cur) {
          if (cur.left != null) {
            stack.push(cur.left);
          } else if (cur.right != null) {
            stack.push(cur.right);
          }
        } else if (cur.left == prev) { // left sub-tree has been traversed
          if (cur.right != null) {
            stack.push(cur.right);
          }
        } else {
          res.add(cur.val);
          stack.pop();
        }
        prev = cur;
      }

      return res;
    }
  }

}
