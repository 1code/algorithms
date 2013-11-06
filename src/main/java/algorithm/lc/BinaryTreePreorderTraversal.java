package algorithm.lc;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * For example: Given binary tree {1,#,2,3}, 
 *   1 
 *    \ 
 *     2 
 *    / 
 *   3 
 *   
 * return [1,2,3].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 */
public class BinaryTreePreorderTraversal {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  /**
   * O(n) space, O(n) time. 
   *
   */
  public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
      // IMPORTANT: Please reset any member data you declared, as
      // the same Solution instance will be reused for each test case.
      ArrayList<Integer> res = new ArrayList<Integer>();
      Stack<TreeNode> stack = new Stack<TreeNode>();
      if (root != null) {
        stack.push(root);
      }

      while (!stack.isEmpty()) {
        TreeNode cur = stack.pop();
        res.add(cur.val);
        if (cur.right != null) {
          stack.push(cur.right);
        }
        if (cur.left != null) {
          stack.push(cur.left);
        }
      }
      return res;
    }
  }

}
