package algorithm.lc;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's
 * key. The right subtree of a node contains only nodes with keys greater than
 * the node's key. Both the left and right subtrees must also be binary search
 * trees.
 * 
 */
public class ValidateBinarySearchTree {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public class Solution {
    public boolean isValidBST(TreeNode root) {
          // Start typing your Java solution below
          // DO NOT write main() function
      return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean validate(TreeNode node, int min, int max) {
      if (node == null) {
        return true;
      }
      if (node.val <= min || node.val >= max) {
        return false;
      }
      return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
  }

}
