package algorithm.cc150.chapter2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Random;

import org.junit.Test;

import algorithm.TestBase;
import algorithm.common.ListNode;
import algorithm.util.Utils;

/**
 * Given a circular linked list, implement an algorithm which returns the node
 * at the beginning of the loop.
 * 
 * DEFINITION Circular linked list: A (corrupt) linked list in which a node's
 * next pointer points to an earlier node, so as to make a loop in the linked
 * list.
 * 
 * EXAMPLE Input: A-> B -> C -> D -> E -> C [the same C as earlier Output: C
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
    // test empty list
    ListNode headEmpty = null;
    assertNull(question.findLoop(headEmpty));
    
    // test one-element list
    ListNode oneElemList = new ListNode(1);
    assertNull(question.findLoop(oneElemList));
    
    // test 10 random generated circular list
    for (int c = 0; c < 10; ++c) {
      Random rnd = new Random();
      // test circular list
      int loopNodeIdx = rnd.nextInt(10);
      
      ListNode head = new ListNode(0);
      ListNode loopNode = head;
      ListNode cur = head;
      for (int i = 1; i < 10; ++i) {
        cur.next = new ListNode(i);
        if (i == loopNodeIdx) {
          loopNode = cur.next;
        }
        cur = cur.next;
      }
      cur.next = loopNode; // at the circular at the end
      ListNode identifiedLoop = question.findLoop(head);
      assertEquals(loopNode.val, identifiedLoop.val);
    }
  }

  @Override
  @Test
  public void testNegCase() {
    // no negative case
  }

}
