package algorithm.lc;

/**
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root
 * node down to the farthest leaf node.
 * 
 */
// O(1) space, O(n) time
public class MaximumDepthOfBinaryTree {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public class Solution {
    public int maxDepth(TreeNode root) {
      // Start typing your Java solution below
      // DO NOT write main() function
      if (root == null) {
        return 0;
      }
      return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
  }

}
