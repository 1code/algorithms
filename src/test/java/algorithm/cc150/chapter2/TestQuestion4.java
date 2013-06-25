package algorithm.cc150.chapter2;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

import algorithm.TestBase;
import algorithm.cc150.chapter2.Question4.Node;
import algorithm.cc150.chapter2.Question4.Pair;

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
      int length = rnd.nextInt(100);
      int x = rnd.nextInt(length);
      Node<Integer> head = null;
      Node<Integer> cur = head;
      for (int i = 0; i < length; ++i) {
        cur = new Node<Integer>(i);
        cur = cur.next;
      }
      Pair<Integer> pair = question.partition(head, x);
      Node<Integer> first = pair.first;
      Node<Integer> second = pair.second;
      while (first != null) {
        assertTrue(x > first.elem.intValue());
        first = first.next;
      }
      
      while (second != null) {
        assertTrue(x <= second.elem.intValue());
        second = second.next;
      }
    }
  }

  @Override
  @Test
  public void testNegCase() {
    //  no negative case
  }

  
}
