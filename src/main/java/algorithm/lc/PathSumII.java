package algorithm.lc;

import java.util.ArrayList;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * For example: Given the below binary tree and sum = 22, 
 *         5 
 *        / \ 
 *       4   8 
 *      /   / \ 
 *    11   13   4 
 *   / \   / \ 
 *  7   2 5   1 
 *   
 * return
 * 
 * [ [5,4,11,2], [5,8,4,5] ]
 * 
 */
public class PathSumII {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  // O(nlgn) space, O(n) time
  public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
      // Start typing your Java solution below
      // DO NOT write main() function
      ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
      if (root == null) {
        return res;
      }
      ArrayList<Integer> cur = new ArrayList<Integer>();
      int curSum = 0;
      getSum(root, sum, cur, curSum, res);
      return res;
    }

    private void getSum(TreeNode node, int sum, ArrayList<Integer> cur,
        int curSum, ArrayList<ArrayList<Integer>> res) {

      if (node.left == null && node.right == null) {
        if (curSum + node.val == sum) {
          ArrayList<Integer> copy = new ArrayList<Integer>(cur);
          copy.add(node.val);
          res.add(copy);
        }
      } else {
        cur.add(node.val);
        if (node.left != null) {
          getSum(node.left, sum, cur, curSum + node.val, res);
        }
        if (node.right != null) {
          getSum(node.right, sum, cur, curSum + node.val, res);
        }
        cur.remove(cur.size() - 1);
      }

    }
  }
}
