package algorithm.cc150.chapter4;

/**
 * Given a binary search tree, design an algorithm which creates a linked list
 * of all the nodes at each depth (e.g., if you have a tree with depth D, you'll
 * have D linked lists).
 * 
 */
public class Question4 {

  // this question is available at leetcode, question Populating Next Right
  // Pointers in Each Node I and II
  public class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
      val = x;
    }
  }

  public void connect(TreeLinkNode root) {
    // Start typing your Java solution below
    // DO NOT write main() function
    populate(root, null);
  }

  private void populate(TreeLinkNode node, TreeLinkNode parent) {
    if (node == null) {
      return;
    }
    if (node.left != null) {
      node.left.next = node.right;
    }
    if (node.right != null && node.next != null) {
      node.right.next = node.next.left;
    }

    populate(node.right, node);
    populate(node.left, node);
  }

}
