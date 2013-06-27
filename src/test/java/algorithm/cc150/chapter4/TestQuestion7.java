package algorithm.cc150.chapter4;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithm.TestBase;
import algorithm.cc150.chapter4.Question7.Node;

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
    //  empty tree
    assertEquals(null, question.lca(null, null, null));
    
    //  all the same node
    Node<Integer> root = new Node<Integer>(1);
    assertEquals(root.elem, question.lca(root, root, root).elem);
    
    //  lca is first
    Node<Integer> root2 = new Node<Integer>(1);
    Node<Integer> left2 = new Node<Integer>(2);
    root2.left = left2;
    assertEquals(root2.elem, question.lca(root2, root2, left2).elem);
    assertEquals(root2.elem, question.lca(root2, left2, root2).elem);
    
    //  lca is root
    Node<Integer> root3 = new Node<Integer>(1);
    Node<Integer> left3 = new Node<Integer>(2);
    Node<Integer> right3 = new Node<Integer>(3);
    root3.left = left3;
    root3.right = right3;
    assertEquals(root3.elem, question.lca(root3, left3, right3).elem);
    
    //  more complex example
    Node<Integer> root4 = new Node<Integer>(1);
    Node<Integer> level2l = new Node<Integer>(2);
    Node<Integer> level2r = new Node<Integer>(3);
    root4.left = level2l;
    root4.right = level2r;
    Node<Integer> level3rl = new Node<Integer>(4);
    Node<Integer> level3rr = new Node<Integer>(5);
    level2r.left = level3rl;
    level2r.right = level3rr;
    Node<Integer> level4rll = new Node<Integer>(6);
    Node<Integer> level4rrl = new Node<Integer>(7);
    Node<Integer> level4rrr = new Node<Integer>(8);
    level3rl.left = level4rll;
    level3rr.left = level4rrl;
    level3rr.right = level4rrr;
    assertEquals(root4.elem, question.lca(root, level2l, level4rrr).elem);
    assertEquals(level2r.elem, question.lca(root, level3rl, level3rr));
    assertEquals(level2r.elem, question.lca(root, level3rl, level4rrr));
    
  }

  @Override
  @Test
  public void testNegCase() {
    //  no negative case
  }

}
