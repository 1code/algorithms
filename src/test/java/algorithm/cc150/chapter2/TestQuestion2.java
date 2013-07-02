package algorithm.cc150.chapter2;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

import algorithm.TestBase;
import algorithm.cc150.chapter2.Question2.Node;

public class TestQuestion2 extends TestBase {

  private Question2 question;

  @Override
  protected void initInstance() {
    question = new Question2();
  }

  @Override
  @Test
  public void testPosCase() {

    Random rnd = new Random();
    for (int c = 0; c < 100; ++c) {
      // create list with length 100
      Node<Integer> head = new Node<Integer>(0);
      Node<Integer> cur = head;
      for (int i = 1; i < 100; ++i) {
        Node<Integer> node = new Node<Integer>(i);
        cur.next = node;
        cur = node;
      }
      int k = rnd.nextInt(100);
      // find the kth to the last
      assertEquals(99 - k, question.findKthToLast(k, head).elem.intValue());
    }

  }

  @Override
  @Test
  public void testNegCase() {
    // no negative case
  }

}
