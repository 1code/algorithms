package algorithm.lc;


/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 */
// O(n) space, O(n) time
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  // use postorder to find the root, and use root in inorder to get left and
  // right subtree
  public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
      return buildTree(inorder, 0, inorder.length - 1, postorder, 0,
          postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int inFrom, int inTo,
        int[] postorder, int postFrom, int postTo) {
      if (postFrom > postTo) { // no available root
        return null;
      }

      TreeNode root = new TreeNode(postorder[postTo]);

      int rootInorderIdx = -1;
      for (int x = inFrom; x <= inTo; x++)
        if (inorder[x] == postorder[postTo]) {
          rootInorderIdx = x;
          break;
        }
      int postLeftEnd = postFrom + (rootInorderIdx - inFrom - 1);
      root.left = buildTree(inorder, inFrom, rootInorderIdx - 1, postorder,
          postFrom, postLeftEnd);
      root.right = buildTree(inorder, rootInorderIdx + 1, inTo, postorder,
          postLeftEnd + 1, postTo - 1);
      
      return root;
    }
  }
  
}
