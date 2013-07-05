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
    populate(root);
  }

  private void populate(TreeLinkNode node) {
    if (node == null) {
      return;
    }
    TreeLinkNode needNext = null;
    if (node.left != null) {
      needNext = node.left;
      if (node.right != null) {
        node.left.next = node.right;
      }
    }

    if (node.right != null) {
      needNext = node.right;
    }

    if (needNext != null && node.next != null) {
      TreeLinkNode nextParent = node.next;
      while (nextParent != null) {
        if (nextParent.left != null) {
          needNext.next = nextParent.left;
          break;
        }
        if (nextParent.right != null) {
          needNext.next = nextParent.right;
          break;
        }
        nextParent = nextParent.next;
      }
    }
    populate(node.right);
    populate(node.left);
  }
  
}