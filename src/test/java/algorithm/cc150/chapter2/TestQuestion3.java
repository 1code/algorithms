package algorithm.cc150.chapter2;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

import algorithm.TestBase;
import algorithm.cc150.chapter2.Question3.Node;

/**
 * Implement an algorithm to delete a node in the middle of a singly linked
 * list, given only access to that node.
 * 
 * 
 * EXAMPLE
 * 
 * Input: the node c from the linked list a ->b ->c ->d ->e
 * 
 * Result: nothing is returned, but the new linked list looks like a ->b ->d ->e
 * 
 */
public class TestQuestion3 extends TestBase {

  private Question3 question;

  @Override
  protected void initInstance() {
    question = new Question3();
  }

  @Override
  @Test
  public void testPosCase() {

    Random rnd = new Random();

    Node<Integer> actualList = new Node<Integer>(-1);
    Node<Integer> expectedList = new Node<Integer>(-1);
    Node<Integer> curActualList = actualList;
    Node<Integer> curExpectedList = expectedList;
    int length = 2 * rnd.nextInt(10) + 1;
    for (int i = 0; i < length; ++i) {
      curActualList.next = new Node<Integer>(i);
      curActualList = curActualList.next;
      if (i != length / 2) {
        curExpectedList.next = new Node<Integer>(i);
        curExpectedList = curExpectedList.next;
      }
    }

    curActualList = actualList;
    curExpectedList = expectedList;
    while (expectedList != null) {
      assertEquals(curExpectedList.elem.intValue(),
          curActualList.elem.intValue());
      curActualList = curActualList.next;
      curExpectedList = curExpectedList.next;
    }

  }

  @Override
  @Test
  public void testNegCase() {
    // no positive case
  }

}
