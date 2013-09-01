package algorithm.lc;

/**
 * Given a binary tree, find the maximum path sum.
 * 
 * The path may start and end at any node in the tree.
 * 
 * For example: Given the below binary tree,
 * 
 * 1 / \ 2 3
 * 
 * Return 6.
 */
// O(1) space, O(n) time
public class BinaryTreeMaximumPathSum {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public class Solution {
    public int maxPathSum(TreeNode root) {
      // Start typing your Java solution below
      // DO NOT write main() function
      Wrapper max = new Wrapper(Integer.MIN_VALUE);
      pathSum(root, max);
      return max.val;
    }

    // keep max while return max extensible path sum
    private int pathSum(TreeNode node, Wrapper max) {
      if (node == null) {
        return 0;
      }
      int l = pathSum(node.left, max);
      int r = pathSum(node.right, max);
      // update sub-solution optimum
      max.val = Math.max(max.val, l + r + node.val);
      int extensiblePathSum = Math.max(l, r);
      return Math.max(extensiblePathSum + node.val, 0);
    }

    public class Wrapper {
      int val;

      public Wrapper(int val) {
        this.val = val;
      }
    }
  }

}
