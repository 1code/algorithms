package algorithm.lc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure.
 * 
 * Note: A solution using O(n) space is pretty straight forward. Could you
 * devise a constant space solution?
 * 
 */
public class RecoverBinarySearchTree {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  // O(n) space, O(nlgn) time
  public class Solution {
    // inorder traversal and record all the values, then sort the values and
    // fill all the values to the nodes in order
    public void recoverTree(TreeNode root) {
      // Start typing your Java solution below
      // DO NOT write main() function
      List<TreeNode> nodeList = new ArrayList<TreeNode>();
      List<Integer> valList = new ArrayList<Integer>();

      inorder(root, nodeList, valList);
      Collections.sort(valList);
      for (int i = 0; i < nodeList.size(); ++i) {
        nodeList.get(i).val = valList.get(i);
      }
    }

    private void inorder(TreeNode node, List<TreeNode> nodeList,
        List<Integer> valList) {
      if (node == null) {
        return;
      }
      inorder(node.left, nodeList, valList);
      nodeList.add(node);
      valList.add(node.val);
      inorder(node.right, nodeList, valList);
    }
  }

  // O(1) space, O(n) time
  // extend the inorder traversal, use two pointers to track the nodes that
  // needs to be swaped
  public class SolutionConstantSpace {
    public void recoverTree(TreeNode root) {
      // Start typing your Java solution below
      // DO NOT write main() function
      Wrapper first = new Wrapper();
      Wrapper second = new Wrapper();
      Wrapper pre = new Wrapper();

      inorder(root, first, second, pre);
      // swap two nodes
      int val = first.node.val;
      first.node.val = second.node.val;
      second.node.val = val;
    }

    private void inorder(TreeNode node, Wrapper first, Wrapper second,
        Wrapper pre) {
      if (node == null) {
        return;
      }
      inorder(node.left, first, second, pre);
      if (pre.node != null && node.val < pre.node.val) {
        if (first.node == null) {
          first.node = pre.node;
        }
        second.node = node;
      }
      pre.node = node;
      inorder(node.right, first, second, pre);
    }

    public class Wrapper {
      TreeNode node;
    }
  }

}
