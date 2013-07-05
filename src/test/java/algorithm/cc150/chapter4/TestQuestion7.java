package algorithm.cc150.chapter4;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithm.TestBase;
import algorithm.cc150.chapter4.Question7.TreeNode;

/**
 * Design an algorithm and write code to find the first common ancestor of two
 * nodes in a binary tree. Avoid storing additional nodes in a data structure.
 * NOTE: This is not necessarily a binary search tree.
 * 
 */
public class TestQuestion7 extends TestBase {

  private Question7 question;

  @Override
  protected void initInstance() {
    question = new Question7();
  }

  @Override
  @Test
  public void testPosCase() {
    // empty tree
    assertEquals(null, question.lca(null, null, null));

    // all the same node
    TreeNode root = new TreeNode(1);
    assertEquals(root.val, question.lca(root, root, root).val);

    // lca is first
    TreeNode root2 = new TreeNode(1);
    TreeNode left2 = new TreeNode(2);
    root2.left = left2;
    assertEquals(root2.val, question.lca(root2, root2, left2).val);
    assertEquals(root2.val, question.lca(root2, left2, root2).val);

    // lca is root
    TreeNode root3 = new TreeNode(1);
    TreeNode left3 = new TreeNode(2);
    TreeNode right3 = new TreeNode(3);
    root3.left = left3;
    root3.right = right3;
    assertEquals(root3.val, question.lca(root3, left3, right3).val);

    // more complex example
    /*
     *                    1
     *                  /   \
     *                2       3
     *                      /   \
     *                    4       5
     *                   /      /   \
     *                  6      7     8
     */
    TreeNode one = new TreeNode(1);
    TreeNode two = new TreeNode(2);
    TreeNode three = new TreeNode(3);
    one.left = two;
    one.right = three;
    TreeNode four = new TreeNode(4);
    TreeNode five = new TreeNode(5);
    three.left = four;
    three.right = five;
    TreeNode six = new TreeNode(6);
    TreeNode seven = new TreeNode(7);
    TreeNode eight = new TreeNode(8);
    four.left = six;
    five.left = seven;
    five.right = eight;
    assertEquals(one.val, question.lca(one, two, eight).val);
    assertEquals(three.val, question.lca(one, four, five).val);
    assertEquals(three.val, question.lca(one, four, eight).val);
    assertEquals(three.val, question.lca(one, three, three).val);
    assertEquals(five.val, question.lca(one, seven, eight).val);

  }

  @Override
  @Test
  public void testNegCase() {
    // no negative case
  }

}
