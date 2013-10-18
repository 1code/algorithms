package algorithm.lc;

import java.util.ArrayList;

/**
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 *
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 *
 *  1         3     3      2      1
 *   \       /     /      / \      \
 *    3     2     1      1   3      2
 *   /     /       \                 \
 *  2     1         2                 3 
 *
 */
// O(n * n!) space, O(n!) time
public class UniqueBinarySearchTreeII {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
      left = null;
      right = null;
    }
  }

  // recursively construct the left and right subtree,
  // then use a nested loop to concatenate root, left, and right trees
  public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
      // Start typing your Java solution below
      // DO NOT write main() function
      ArrayList<TreeNode> trees = generate(1, n);
      return trees;
    }

    private ArrayList<TreeNode> generate(int from, int to) {
      ArrayList<TreeNode> trees = new ArrayList<TreeNode>();
      if (from > to) {
        trees.add(null);
        return trees;
      }

      for (int i = from; i <= to; ++i) {
        ArrayList<TreeNode> leftRoots = generate(from, i - 1);
        ArrayList<TreeNode> rightRoots = generate(i + 1, to);

        for (TreeNode leftRoot : leftRoots) {
          for (TreeNode rightRoot : rightRoots) {
            TreeNode root = new TreeNode(i);
            root.left = leftRoot;
            root.right = rightRoot;
            trees.add(root);
          }
        }
      }
      return trees;
    }
    
  }

}
