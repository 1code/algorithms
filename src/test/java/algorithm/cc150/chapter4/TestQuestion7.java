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
    TreeNode root4 = new TreeNode(1);
    TreeNode level2l = new TreeNode(2);
    TreeNode level2r = new TreeNode(3);
    root4.left = level2l;
    root4.right = level2r;
    TreeNode level3rl = new TreeNode(4);
    TreeNode level3rr = new TreeNode(5);
    level2r.left = level3rl;
    level2r.right = level3rr;
    TreeNode level4rll = new TreeNode(6);
    TreeNode level4rrl = new TreeNode(7);
    TreeNode level4rrr = new TreeNode(8);
    level3rl.left = level4rll;
    level3rr.left = level4rrl;
    level3rr.right = level4rrr;
    assertEquals(root4.val, question.lca(root, level2l, level4rrr).val);
    assertEquals(level2r.val, question.lca(root, level3rl, level3rr));
    assertEquals(level2r.val, question.lca(root, level3rl, level4rrr));

  }

  @Override
  @Test
  public void testNegCase() {
    // no negative case
  }

}
