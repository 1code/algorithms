package algorithm.cc150.chapter2;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

import algorithm.TestBase;
import algorithm.cc150.chapter2.Question6.Node;

/**
 * Given a circular linked list, implement an algorithm which returns the node
 * at the beginning of the loop.
 * 
 * DEFINITION 
 * Circular linked list: A (corrupt) linked list in which a node's
 * next pointer points to an earlier node, so as to make a loop in the linked
 * list.
 * 
 * EXAMPLE
 * Input: A-> B -> C -> D -> E -> C [the same C as earlier
 * Output: C
 * 
 */
public class TestQuestion6 extends TestBase {
  
  private Question6 question;

  @Override
  protected void initInstance() {
    question = new Question6();
  }

  @Override
  @Test
  public void testPosCase() {
    //  test empty list
    Node<Integer> headEmpty = null;
    question.findLoop(headEmpty);
    
    Random rnd = new Random();
    //  test circular list
    Node<Integer> head = new Node<Integer>(0);
    Node<Integer> cur = head;
    int loopNodeIdx = rnd.nextInt(10);
    Node<Integer> loopNode = null;
    for (int i = 1; i < 10; ++i) {
      cur.next = new Node<Integer>(i);
      cur = cur.next;
      if (i == loopNodeIdx) {
        loopNode = new Node<Integer>(loopNodeIdx);
      }
    }
    cur.next = loopNode;
    Node<Integer> identifiedLoop = question.findLoop(head);
    assertEquals(loopNode.elem.intValue(), identifiedLoop.elem.intValue());
  }

  @Override
  @Test
  public void testNegCase() {
    //  no negative case
  }

}
