package algorithm.lc;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 */
// O(n) space, O(n) time
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      // Start typing your Java solution below
      // DO NOT write main() function
      return build(preorder, 0, preorder.length - 1, inorder, 0,
          inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preFrom, int preTo,
        int[] inorder, int inFrom, int inTo) {
      if (preFrom > preTo) {
        return null;
      }

      int rootInorderIdx = -1;
      for (int i = inFrom; i <= inTo; ++i) {
        if (inorder[i] == preorder[preFrom]) {
          rootInorderIdx = i;
          break;
        }
      }

      TreeNode root = new TreeNode(preorder[preFrom]);
      int preLeftEnd = preFrom + 1 + (rootInorderIdx - inFrom - 1);
      root.left = build(preorder, preFrom + 1, preLeftEnd, inorder, inFrom, rootInorderIdx - 1);
      root.right = build(preorder, preLeftEnd + 1, preTo, inorder, rootInorderIdx + 1, inTo);
      return root;
    }
  }

}
