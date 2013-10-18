package algorithm.basic;

import java.util.Iterator;
import java.util.Stack;

public class BST {
  
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    public TreeNode(int val) {
      this.val = val;
    }
  }
  
  private TreeNode root;
  
  public BST() {
    root = null;
  }
  
  public void insert(int val) {
    if (root == null) {
      root = new TreeNode(val);
    }
    else {
      insertHelper(root, val);
    }
  }
  
  private void insertHelper(TreeNode node, int val) {
    if (val <= node.val) {
      if (node.left == null) {
        node.left = new TreeNode(val);
      }
      else {
        insertHelper(node.left, val);
      }
    }
    else {
      if (node.right == null) {
        node.right = new TreeNode(val);
      }
      else {
        insertHelper(node.right, val);
      }
    }
  }
  
  public int size() {
    return size(root);
  }
  
  private int size(TreeNode node) {
    if (node == null) {
      return 0;
    }
    return 1 + size(node.left) + size(node.right);
  }
  
  public int height() {
    return height(root);
  }
  
  private int height(TreeNode node) {
    if (node == null) {
      return 0;
    }
    return 1 + Math.max(height(node.left), height(node.right));
  }
  
  public int diameter() {
    return diameter(root);
  }
  
  public int diameter(TreeNode node) {
    if (node == null) {
      return 0;
    }
    
    int leftHeight = height(node.left);
    int rightHeight = height(node.right);
    
    int leftDiameter = diameter(node.left);
    int rightDiameter = diameter(node.right);
    
    return Math.max(1 + leftHeight + rightHeight, Math.max(leftDiameter, rightDiameter));
  }
  
  public boolean search(int val) {
    TreeNode cur = root;
    
    while (cur != null) {
      if (cur.val == val) {
        return true;
      }
      else if (cur.val < val) {
        cur = cur.right;
      }
      else {
        cur = cur.left;
      }
    }
    return false;
  }
  
  public void delete(TreeNode node) {
    // assume the node is in the tree
    delete(root, node);
  }
  
  private TreeNode getParent(TreeNode node) {
    if (node == root) {
      return null;
    }
    
    TreeNode cur = root;
    while (cur != null) {
      if (cur.left == node || cur.right == node) {
        return cur;
      }
      else if (cur.val <= node.val){
        cur = cur.right;
      }
      else {
        cur = cur.left;
      }
    }
    // node not in the tree
    return null;
  }
  
  private TreeNode getRightSmallestNode(TreeNode node) {
    TreeNode cur = node;
    while (cur.left != null) {
      if (cur.left != null) {
        cur = cur.left;
      }
    }
    
    return cur;
  }
  
  public void delete(TreeNode root, TreeNode node) {
    if (node == null) {
      return;
    }
    
    TreeNode parent = getParent(node);
    if (node.left == null && node.right == null) {
      if (parent.left == node) {
        parent.left = null;
      }
      else {
        parent.right = null;
      }
    }
    else if (node.left == null) {
      if (parent.left == node) {
        parent.left = node.right;
      }
      else {
        parent.right = node.right;
      }
    }
    else if (node.right == null) {
      if (parent.left == node) {
        parent.left = node.left;
      }
      else {
        parent.right = node.left;
      }
    }
    else {
      TreeNode rightSmallest = getRightSmallestNode(node);
      node.val = rightSmallest.val;
      delete(rightSmallest);
    }
    
  }
  
  public class TreeIterator implements Iterator<TreeNode> {

    private Stack<TreeNode> stack;
    private TreeNode cur;
    
    public TreeIterator() {
      cur = root;
    }
    
    @Override
    public boolean hasNext() {
      return (cur != null || !stack.isEmpty());
    }

    @Override
    public TreeNode next() {
      while (cur != null) {
        stack.push(cur);
        cur = cur.left;
      }
      
      TreeNode node = stack.pop();
      cur = node.right;
      
      return node;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }
    
  }

}
