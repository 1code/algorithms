package algorithm.lc;

/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * 
 * What if the given tree could be any binary tree? Would your previous solution
 * still work?
 * 
 * Note:
 * 
 * You may only use constant extra space. For example, Given the following
 * binary tree,
 * 
 *        1 
 *       / \ 
 *      2   3 
 *     / \   \ 
 *    4   5   7 
 * After calling your function, the tree should look like:
 * 
 *        1 -> NULL 
 *      /   \ 
 *     2  -> 3 -> NULL 
 *    / \     \ 
 *   4 -> 5 -> 7 -> NULL
 * 
 */
public class PopulatingNextRightPointersInEachNodeII {

  public class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
      val = x;
    }
  }

  // O(1) space, O(n) time
  // recurively linke right sub-tree and left sub-tree
  public class Solution {
    public void connect(TreeLinkNode root) {
          // Start typing your Java solution below
          // DO NOT write main() function
      if (root == null) {
        return;
      }       
      TreeLinkNode linkToNext = null;
      if (root.left != null) {
        root.left.next = root.right;
        linkToNext = root.left;
      }
      if (root.right != null) {
        linkToNext = root.right;
      }
      // link next to another sub-tree
      TreeLinkNode nextToLink = null;
      TreeLinkNode nextNode = root.next;
      while (nextNode != null && nextToLink == null) {
        if (nextNode.left != null) {
          nextToLink = nextNode.left;
        }
        else {
          nextToLink = nextNode.right;
        }
        nextNode = nextNode.next;
      }
      
      if (linkToNext != null) {
        linkToNext.next = nextToLink;
      }
      
      connect(root.right);
      connect(root.left);
    }
  }
  
  public class Solution2 {
    public void connect(TreeLinkNode root) {
          // Start typing your Java solution below
          // DO NOT write main() function
      if (root == null) {
        return;
      }       
      if (root.right != null && root.left != null) {  // link the left to right
        root.left.next = root.right;
      }
      if (root.next != null) { // link the right to next
        TreeLinkNode nextStart = root.right == null? root.left : root.right;
        if (nextStart != null) {
          TreeLinkNode nextEndParent = root.next;
          while (nextEndParent != null && nextEndParent.left == null && nextEndParent.right == null) {
            nextEndParent = nextEndParent.next;
          }
          if (nextEndParent != null) {
            if (nextEndParent.left != null) {
              nextStart.next = nextEndParent.left;
            }
            else {
              nextStart.next = nextEndParent.right;
            }
          }
        }
      }
      connect(root.right);
      connect(root.left);
    }
  }

}