package algorithm.lc;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * 
 * Two binary trees are considered equal if they are structurally identical and
 * the nodes have the same value.
 * 
 */
// O(n) space, O(n) time
public class SameTree {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
      // Start typing your Java solution below
      // DO NOT write main() function
      Queue<TreeNode> pTree = new LinkedList<TreeNode>();
      Queue<TreeNode> qTree = new LinkedList<TreeNode>();
      pTree.offer(p);
      qTree.offer(q);
      while (pTree.peek() != null || qTree.peek() != null) {
        if (pTree.peek() == null || qTree.peek() == null) {
          return false;
        }

        TreeNode first = pTree.poll();
        TreeNode second = qTree.poll();

        if (first.val != second.val
            || (first.left == null) != (second.left == null)
            || (first.right == null != (second.right == null))) {
          return false;
        }
        if (first.left != null) {
          pTree.offer(first.left);
          qTree.offer(second.left);
        }
        if (first.right != null) {
          pTree.offer(first.right);
          qTree.offer(second.right);
        }

      }
      return true;
    }
  }

}
