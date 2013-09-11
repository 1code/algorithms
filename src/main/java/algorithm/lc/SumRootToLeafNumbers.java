package algorithm.lc;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 * could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * For example,
 * 
 *        1 
 *       / \ 
 *      2   3 
 * 
 * The root-to-leaf path 1->2 represents the number 12. The
 * root-to-leaf path 1->3 represents the number 13.
 * 
 * Return the sum = 12 + 13 = 25.
 * 
 */
// O(1) space, O(n) time
public class SumRootToLeafNumbers {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public class Solution {
    public int sumNumbers(TreeNode root) {
      // Start typing your Java solution below
      // DO NOT write main() function
      int subTotal = 0;
      Wrapper sum = new Wrapper(0);
      getNumbers(root, subTotal, sum);
      return sum.sum;
    }

    private void getNumbers(TreeNode node, int subTotal, Wrapper wrapper) {
      if (node == null) {
        return;
      }
      if (node.left == null && node.right == null) {
        wrapper.sum += subTotal * 10 + node.val;
      }
      if (node.left != null) {
        getNumbers(node.left, subTotal * 10 + node.val, wrapper);
      }
      if (node.right != null) {
        getNumbers(node.right, subTotal * 10 + node.val, wrapper);
      }
    }

    private class Wrapper {
      int sum;

      public Wrapper(int sum) {
        this.sum = sum;
      }
    }
  }

}
