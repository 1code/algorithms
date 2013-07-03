package algorithm.cc150.chapter2;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

import algorithm.TestBase;
import algorithm.common.ListNode;
import algorithm.util.Utils;

/**
 * Write code to partition a linked list around a value x, such that all nodes
 * less than x come before all nodes greater than or equal to x.
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
    Random rnd = new Random();
    
    for (int c = 0; c < 10; ++c) {
      int length = rnd.nextInt(20) + 10;
      int x = rnd.nextInt(length);
      ListNode head = new ListNode(0);
      ListNode cur = head;
      for (int i = 0; i < length; ++i) {
        cur.next = new ListNode(rnd.nextInt(100));
        cur = cur.next;
      }
      ListNode newHead = question.partition(head, x);
      
      cur = newHead;
      boolean afterX = newHead.val >= x;
      while (cur != null) {
        if (x <= cur.val) {
          afterX = true;
        }
        if (afterX) {
          assertTrue(x <= cur.val);
        }
        cur = cur.next;
      }
    }
  }

  @Override
  @Test
  public void testNegCase() {
    // no negative case
  }

}
