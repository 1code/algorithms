package algorithm.lc;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 * 
 * For example: Given the below binary tree and sum = 22, 
 * 
 *       5 
 *      / \ 
 *     4   8 
 *    /   / \ 
 *   11 13   4 
 *  / \       \ 
 * 7   2       1 
 * 
 * return true, as there exist a root-to-leaf path 5->4->11->2
 * which sum is 22.
 * 
 */
public class PathSum {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  // O(1) space, O(n) time
  public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
          // Note: The Solution object is instantiated only once and is reused by each test case.
      return hasPath(root, sum, 0);      
    }
    
    private boolean hasPath(TreeNode node, int sum, int curSum) {
      if (node == null) {
        return false;
      }
      
      if (node.left == null && node.right == null) {
        return curSum + node.val == sum;
      } else {
        return hasPath(node.left, sum, curSum + node.val) || hasPath(node.right, sum, curSum + node.val);
      }
    }
  }

}
