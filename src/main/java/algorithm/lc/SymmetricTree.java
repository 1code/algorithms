package algorithm.lc;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center).
 * 
 * For example, this binary tree is symmetric:
 * 
 *         1 
 *        / \ 
 *       2   2 
 *      / \ / \ 
 *     3  4 4  3 
 *     
 * But the following is not:
 * 
 *         1
 *        / \ 
 *       2   2 
 *        \   \ 
 *         3   3 
 * Note: Bonus points if you could solve it both recursively
 * and iteratively.
 * 
 */
// O(1) space, O(n) time
public class SymmetricTree {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public class Solution {
    public boolean isSymmetric(TreeNode root) {
      // Start typing your Java solution below
      // DO NOT write main() function
      if (root == null) {
        return true;
      }
      return sym(root.left, root.right);
    }

    private boolean sym(TreeNode left, TreeNode right) {
      if (left != null && right != null) {
        return left.val == right.val && sym(left.left, right.right)
            && sym(left.right, right.left);
      }
      return left == null && right == null;
    }
  }
  
  /**
   * Definition for binary tree
   * public class TreeNode {
   *     int val;
   *     TreeNode left;
   *     TreeNode right;
   *     TreeNode(int x) { val = x; }
   * }
   */
  public class SolutionRecursive {
    public boolean isSymmetric(TreeNode root) {
          // Start typing your Java solution below
          // DO NOT write main() function
      
      Queue<TreeNode> left = new LinkedList<TreeNode>();
      Queue<TreeNode> right = new LinkedList<TreeNode>();
      left.offer(root);
      right.offer(root);
      // match two sub-tree by level
      while (left.peek() != null || right.peek() != null) {
        if (left.peek() == null || right.peek() == null) {
          return false;
        }
        TreeNode l = left.poll();
        TreeNode r = right.poll();
        if (l.val != r.val 
          || (l.left == null) != (r.right == null) 
          || (l.right == null) != (r.left == null)) {
          return false;
        }
        else {
          if (l.left != null) {
            left.offer(l.left);
            right.offer(r.right);
          }
          if (l.right != null) {
            left.offer(l.right);
            right.offer(r.left);
          }
        }
      }
      return true;
    }
    
  }

}
