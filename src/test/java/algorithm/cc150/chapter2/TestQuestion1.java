package algorithm.cc150.chapter2;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.LinkedList;

import org.junit.Test;

import algorithm.TestBase;

/**
 * Write code to remove duplicates from an unsorted linked list.
 * 
 * FOLLOW UP
 * 
 * How would you solve this problem if a temporary buffer is not allowed?
 * 
 */
public class TestQuestion1 extends TestBase {

  private Question1 question;

  @Override
  protected void initInstance() {
    question = new Question1();
  }

  @Override
  @Test
  public void testPosCase() {
    /*
     * 1. create an list. 2. fill in unique numbers 3. get a copy list 3. fill
     * in duplicate numbers. 4. shuffle original list 5. call removeDuplicate
     */
    LinkedList<Integer> list1 = new LinkedList<Integer>();
    for (int i = 0; i < 100; ++i) {
      list1.add(i);
    }

    LinkedList<Integer> list1Copy = new LinkedList<Integer>(list1);
    // add duplicate
    for (int i = 0; i < 10; ++i) {
      list1.add(i);
    }

    Collections.shuffle(list1);
    question.removeDuplicate(list1);
    Collections.sort(list1);
    assertEquals(list1Copy, list1);

    LinkedList<Integer> list2 = new LinkedList<Integer>();
    for (int i = 0; i < 100; ++i) {
      list2.add(i);
    }

    LinkedList<Integer> list2Copy = new LinkedList<Integer>(list2);
    // add duplicate
    for (int i = 0; i < 10; ++i) {
      list2.add(i);
    }

    Collections.shuffle(list2);
    question.removeDuplicateWithoutBuffer(list2);
    Collections.sort(list2);
    assertEquals(list2Copy, list2);
  }

  @Override
  @Test
  public void testNegCase() {
    // no negative test case
  }

}
