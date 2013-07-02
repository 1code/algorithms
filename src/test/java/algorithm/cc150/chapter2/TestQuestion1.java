package algorithm.cc150.chapter2;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import algorithm.TestBase;
import algorithm.common.ListNode;
import algorithm.util.Utils;

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
    int[] arr = new int[] {1, 6, 8, 7, 8, 6, 8, 1, 6, 6, 8, 1};
    int[] expectArr = new int[] {1, 6, 8, 7};
    ListNode head = ListNode.arrayToList(arr);
    ListNode expectHead = ListNode.arrayToList(expectArr);
    question.removeDuplicateWithoutBuffer(head);
    assertTrue(ListNode.listEqual(head, expectHead));
   
  }
  
  @Override
  @Test
  public void testNegCase() {
    // no negative test case
  }

}
