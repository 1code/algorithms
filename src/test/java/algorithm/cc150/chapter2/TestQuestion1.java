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
    int[] arr = new int[] {1, 2, 3, 3, 4, 5, 6, 7, 8, 8, 8, 9};
    int[] expectArr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
    ListNode head = arrayToList(arr);
    ListNode expectHead = arrayToList(expectArr);
    Utils.printListNode(head);
    question.removeDuplicateWithoutBuffer(head);
    Utils.printListNode(head);
    assertTrue(listEqual(head, expectHead));
   
  }
  
  private ListNode arrayToList(int[] arr) {
    if (arr == null) {
      return null;
    }
    ListNode head = new ListNode(arr[0]);
    ListNode cur = head;
    for (int i = 1; i < arr.length; ++i) {
      cur.next = new ListNode(arr[i]);
      cur = cur.next;
    }
    return head;
  }
  
  private boolean listEqual(ListNode head1, ListNode head2) {
    if (head1 == null && head2 == null) {
      return true;
    }
    else if (head1 != null && head2 != null) {
      return (head1.val == head2.val) && listEqual(head1.next, head2.next);
    }
    else {
      return false;
    }
  }

  @Override
  @Test
  public void testNegCase() {
    // no negative test case
  }

}
