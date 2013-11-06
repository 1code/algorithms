package algorithm.lc;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * For example: Given binary tree {1,#,2,3},
 * 
 *   1 
 *    \ 
 *     2 
 *    / 
 *   3 
 * 
 * return [1,3,2].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 */
public class BinaryTreeInorderTraversal {
  
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
  
  // O(n) space, O(n) time
  public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
          // Note: The Solution object is instantiated only once and is reused by each test case.
      TreeNode cur = root;
      Stack<TreeNode> stack = new Stack<TreeNode>();
      ArrayList<Integer> res = new ArrayList<Integer>();
      
      while (cur != null || !stack.isEmpty()) {
        // push all left 
        while (cur != null) {
          stack.push(cur);
          cur = cur.left;
        }
        
        TreeNode next = stack.pop();
        res.add(next.val);
        
        // push right
        cur = next.right;
      }
      
      return res;
    }
  }

}
