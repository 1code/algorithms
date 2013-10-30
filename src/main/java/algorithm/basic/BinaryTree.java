package algorithm.basic;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The basic operations of binary tree.
 *
 * @param <T> The comparable element in tree.
 */
public class BinaryTree<T extends Comparable<T>> {
  
  private TreeNode<T> root;

  public BinaryTree() {
    this.root = null;
  }
  
  public void setRoot(TreeNode<T> root) {
          this.root = root;
  }

  public void preorder() {
    preorder(root);
  }

  private void preorder(TreeNode<T> node) {
    if(node != null) {
      System.out.println(node.value);
      preorder(node.left);
      preorder(node.right);
    }
  }

  public void inorder() {
    inorder(root);
  }

  private void inorder(TreeNode<T> node) {
    if(node != null) {
      inorder(node.left);
      System.out.println(node.value);
      inorder(node.right);
    }
  }

  public void postorder() {
    postorder(root);
  }

  private void postorder(TreeNode<T> node) {
    if(node != null) {
      postorder(node.left);
      postorder(node.right);
      System.out.println(node.value);
    }
  }

  public int height() {
    return height(root);
  }

  private int height(TreeNode<T> node) {
    if(node == null) {
      return 0;
    }
    return 1 + Math.max(height(node.left), height(node.right));
  }

  public int size() {
    return size(root);
  }

  private int size(TreeNode<T> node) {
    if(node == null) {
      return 0;
    }
    return 1 + size(node.left) + size(node.right);
  }
  
  public void breathFirstTraversal() {
    Queue<TreeNode<T>> queue = new LinkedList<>();
    queue.add(root);
    while(queue.isEmpty() == false) {
      TreeNode<T> node = queue.poll();
      if(node != null) {
        System.out.println(node.value);
        if(node.left != null) {
          queue.add(node.left);
        }
        if(node.right != null) {
          queue.add(node.right);
        }
      }
    }
  }
  
  public int diameter() {
    return diameter(root);
  }
  
  private int diameter(TreeNode<T> node) {
    if(node == null) {
      return 0;
    }

    int lHeight = height(node.left);
    int rHeight = height(node.right);

    return Math.max(lHeight + rHeight + 1, Math.max(diameter(node.left), diameter(node.right)));
  }

  public static class TreeNode<T> {
    T value;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T value) {
      this(value, null, null);
    }

    public TreeNode(T value, TreeNode<T> left, TreeNode<T> right) {
      this.value = value;
      this.left = left;
      this.right = right;
    }

    public void setLeft(TreeNode<T> left) {
      this.left = left;
    }

    public void setRight(TreeNode<T> right) {
      this.right = right;
    }
  }

}
