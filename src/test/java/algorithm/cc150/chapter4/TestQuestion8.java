package algorithm.cc150.chapter4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import algorithm.TestBase;
import algorithm.cc150.chapter4.Question8.TreeNode;

public class TestQuestion8 extends TestBase {

  private Question8 question;
  
  @Override
  protected void initInstance() {
    question = new Question8();
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
    
    assertTrue(question.isSub(root, eight));
    assertTrue(question.isSub(root, ten));
    assertTrue(question.isSub(root, root));
    assertTrue(question.isSub(eight, ten));
    assertTrue(question.isSub(one, three));
    assertTrue(question.isSub(root, null));
    
  }

  @Override
  @Test
  public void testNegCase() {
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
    
    assertFalse(question.isSub(one, root));
    assertFalse(question.isSub(one, eight));
    assertFalse(question.isSub(one, two));
    assertFalse(question.isSub(one, ten));
    assertFalse(question.isSub(null, root));
  }

}
