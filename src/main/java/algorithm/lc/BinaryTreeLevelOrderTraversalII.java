package algorithm.lc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes'
 * values. (ie, from left to right, level by level from leaf to root).
 * 
 * For example: Given binary tree {3,9,20,#,#,15,7},
 * 
 *       3 
 *      / \ 
 *     9  20 
 *    / \ 
 *   15  7 
 * 
 * return its bottom-up level order traversal as:
 * 
 * [ [15,7] [9,20], [3], ]
 * 
 */
// O(n) space, O(n) time
public class BinaryTreeLevelOrderTraversalII {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public class Solution {
    // use a stack to store the level top-down
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
      // Start typing your Java solution below
      // DO NOT write main() function
      Stack<ArrayList<Integer>> stack = new Stack<ArrayList<Integer>>();

      Queue<TreeNode> queue = new LinkedList<TreeNode>();
      if (root != null) {
        queue.add(root);
      }
      ArrayList<Integer> curLevel = new ArrayList<Integer>();
      ArrayList<TreeNode> nextLevel = new ArrayList<TreeNode>();

      while (!queue.isEmpty()) {
        // pop one level of nodes per time
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
        stack.push(curLevel);
        curLevel = new ArrayList<Integer>();
        queue.addAll(nextLevel);
        nextLevel.clear();
      }

      ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
      while (!stack.isEmpty()) {
        res.add(stack.pop());
      }
      return res;
    }
  }

}
