package algorithm.cc150.chapter4;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import algorithm.TestBase;
import algorithm.cc150.chapter4.Question4.TreeNode;

/**
 * Given a binary search tree, design an algorithm which creates a linked list
 * of all the nodes at each depth (e.g., if you have a tree with depth D, you'll
 * have D linked lists).
 * 
 */
public class TestQuestion4 extends TestBase {
  
  private Question4 question;

  @Override
  protected void initInstance() {
    question = new Question4();
  }

  @Override
  @Test
  public void testPosCase() {
    /*
     *                   0
     *                 /   \
     *               1       2
     *             /   \       \
     *           3      4        5
     *             \     \         \
     *               6     7         8
     *              /               / \
     *            9               10   11
     */
    TreeNode root = new TreeNode(0);
    TreeNode one = new TreeNode(1);
    TreeNode two = new TreeNode(2);
    root.left = one;
    root.right = two;
    TreeNode three = new TreeNode(3);
    TreeNode four = new TreeNode(4);
    TreeNode five = new TreeNode(5);
    one.left = three;
    one.right = four;
    two.right = five;
    TreeNode six = new TreeNode(6);
    TreeNode seven = new TreeNode(7);
    TreeNode eight = new TreeNode(8);
    three.right = six;
    four.right = seven;
    five.right = eight;
    TreeNode nine = new TreeNode(9);
    TreeNode ten = new TreeNode(10);
    TreeNode eleven = new TreeNode(11);
    six.left = nine;
    eight.left = ten;
    eight.right = eleven;
    
    List<List<TreeNode>> lists = question.createLists(root);
    assertEquals(5, lists.size());
    List<TreeNode> level1 = lists.get(0);
    assertEquals(1, level1.size());
    assertEquals(0, level1.get(0).val);
    List<TreeNode> level2 = lists.get(1);
    assertEquals(2, level2.size());
    assertEquals(1, level2.get(0).val);
    assertEquals(2, level2.get(1).val);
    List<TreeNode> level3 = lists.get(2);
    assertEquals(3, level3.size());
    assertEquals(3, level3.get(0).val);
    assertEquals(4, level3.get(1).val);
    assertEquals(5, level3.get(2).val);
    List<TreeNode> level4 = lists.get(3);
    assertEquals(3, level4.size());
    assertEquals(6, level4.get(0).val);
    assertEquals(7, level4.get(1).val);
    assertEquals(8, level4.get(2).val);
    List<TreeNode> level5 = lists.get(4);
    assertEquals(3, level5.size());
    assertEquals(9, level5.get(0).val);
    assertEquals(10, level5.get(1).val);
    assertEquals(11, level5.get(2).val);
  }

  @Override
  @Test
  public void testNegCase() {
    //  no negative case
  }

}
