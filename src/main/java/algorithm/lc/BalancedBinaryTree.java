package algorithm.lc;

public class BalancedBinaryTree {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public class Solution {
    public boolean isBalanced(TreeNode root) {
          // Start typing your Java solution below
          // DO NOT write main() function
      return height(root) < 0 ? false : true;
    }
    
    private int height(TreeNode node) {
      if (node == null) {
        return 0;
      }     
      int left = height(node.left);
      int right = height(node.right);
      
      if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
        return -1;
      }
      return Math.max(left, right) + 1;
    }
    
  }
  
}