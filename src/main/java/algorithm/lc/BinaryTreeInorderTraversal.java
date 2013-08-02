package algorithm.lc;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * For example: Given binary tree {1,#,2,3},
 * 
 *   1 
 *    \ 
 *     2 
 *    / 
 *   3 
 * 
 * return [1,3,2].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 */
public class BinaryTreeInorderTraversal {
  
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
  public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
          // Start typing your Java solution below
          // DO NOT write main() function
      Stack<Pair> stack = new Stack<Pair>();
      ArrayList<Integer> res = new ArrayList<Integer>();
      if (root != null) {
        stack.push(new Pair(root, false));
      }
      while (!stack.isEmpty()) {
        Pair pair = stack.pop();
        if (pair.node.left == null || pair.leftAdded) {
          if (pair.node.right != null) {
            stack.add(new Pair(pair.node.right, false));
          }
          res.add(pair.node.val);
        }
        else {
          pair.leftAdded = true;
          stack.push(pair); // put back current node
          stack.push(new Pair(pair.node.left, false)); // put left on top
        }
      }
      
      return res;
    }
    
    public class Pair {
      public TreeNode node;
      public boolean leftAdded;
      public Pair(TreeNode node, boolean leftAdded) {
        this.node = node;
        this.leftAdded = leftAdded;
      }
    }
  }

}
