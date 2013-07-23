package algorithm.lc;

/**
 * Given an array where elements are sorted in ascending order, convert it to a
 * height balanced BST.
 * 
 */
// O(1) space, O(n) time
public class ConvertSortedArrayToBinarySearchTree {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  // Convert left half subarray to left subtree, right half subarray to right
  // subtree, recursively
  public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
      // Start typing your Java solution below
      // DO NOT write main() function
      return sortedArrayToBST(num, 0, num.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] num, int left, int right) {
      if (left <= right) {
        int mid = (left + right) / 2;
        TreeNode curRoot = new TreeNode(num[mid]);
        curRoot.left = sortedArrayToBST(num, left, mid - 1);
        curRoot.right = sortedArrayToBST(num, mid + 1, right);
        return curRoot;
      } else {
        return null;
      }
    }
  }
}
