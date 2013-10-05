package algorithm.lc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
 * 
 * For example: Given binary tree {3,9,20,#,#,15,7},
 * 
 *          3 
 *         / \ 
 *        9   20 
 *            / \ 
 *           15  7 
 * return its zigzag level order traversal as:
 * 
 * [ [3], [20,9], [15,7] ]
 * 
 */
// O(n) space, O(n) time
public class BinaryTreeZigZagLevelOrderTraversal {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public class Solution {
    // traverse tree by level, if level number is odd, reverse that order
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
      // Start typing your Java solution below
      // DO NOT write main() function
      ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
      ArrayList<Integer> curLevel = new ArrayList<Integer>();
      Queue<TreeNode> queue = new LinkedList<TreeNode>();
      if (root != null) {
        queue.add(root);
      }
      int level = 0;
      while (!queue.isEmpty()) {
        List<TreeNode> nextLevel = new ArrayList<TreeNode>();
        while (!queue.isEmpty()) {
          TreeNode node = queue.poll();
          curLevel.add(node.val);
          if (node.left != null) {
            nextLevel.add(node.left);
          }
          if (node.right != null) {
            nextLevel.add(node.right);
          }
        }
        queue.addAll(nextLevel);
        if (level % 2 == 0) {
          res.add(curLevel);
        } else {
          Collections.reverse(curLevel);
          res.add(curLevel);
        }
        curLevel = new ArrayList<Integer>();
        ++level;
      }
      return res;
    }
  }

}
