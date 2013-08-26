package algorithm.lc;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example, Given
 * 
 *      1 
 *     / \ 
 *    2   5 
 *   / \   \ 
 *  3   4   6 
 *  
 *  The flattened tree should look like: 
 *  1 
 *   \
 *    2 
 *     \ 
 *      3 
 *       \ 
 *        4 
 *         \ 
 *          5
 *           \ 
 *            6
 */
public class FlattenBinaryTreeToLinkedList {

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
    public void flatten(TreeNode root) {
      // Start typing your Java solution below
      // DO NOT write main() function
      flat(root);
    }

    private TreeNode flat(TreeNode node) {
      if (node == null) {
        return node;
      }

      TreeNode tmp = node.right;
      node.right = flat(node.left);
      node.left = null;
      TreeNode right = node;
      while (right.right != null) {
        right = right.right;
      }
      right.right = flat(tmp);
      return node;
    }
  }

}
