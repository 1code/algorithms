package algorithm.lc;

/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * 
 */
public class ConvertSortedListToBinarySearchTree {

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  // O(1) space, O(n) time.
  // Convert left subtree, current node to root, and then convert right subtree
  public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
      // Start typing your Java solution below
      // DO NOT write main() function
      int size = 0;
      ListNode[] wrapper = new ListNode[1];
      wrapper[0] = head;
      while (wrapper[0] != null) {
        ++size;
        wrapper[0] = wrapper[0].next;
      }
      wrapper[0] = head;
      return sortedListToBST(wrapper, 0, size - 1);
    }

    // build left tree, current root , and then right tree
    private TreeNode sortedListToBST(ListNode[] wrapper, int min, int max) {
      if (min <= max) { // non-empty
        int mid = (min + max) / 2;
        TreeNode leftTree = sortedListToBST(wrapper, min, mid - 1);
        TreeNode curRoot = new TreeNode(wrapper[0].val);
        curRoot.left = leftTree;
        wrapper[0] = wrapper[0].next;
        curRoot.right = sortedListToBST(wrapper, mid + 1, max);
        return curRoot;
      } else {
        return null;
      }
    }
  }

}
