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
      List<TreeNode> first = new ArrayList<TreeNode>();
      List<TreeNode> second = new ArrayList<TreeNode>();
      List<TreeNode> pre = new ArrayList<TreeNode>();
      first.add(null);
      second.add(null);
      pre.add(null);

      inorder(root, first, second, pre);
      // swap two nodes
      int val = first.get(0).val;
      first.get(0).val = second.get(0).val;
      second.get(0).val = val;
    }

    private void inorder(TreeNode node, List<TreeNode> first,
        List<TreeNode> second, List<TreeNode> pre) {
      if (node == null) {
        return;
      }
      inorder(node.left, first, second, pre);
      if (pre.get(0) != null && node.val < pre.get(0).val) { // if out-of-order
                                                          // appears
        if (first.get(0) == null) {
          first.set(0, pre.get(0));
        }
        second.set(0, node);
      }
      pre.set(0, node);
      inorder(node.right, first, second, pre);
    }

  }

}
