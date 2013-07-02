package algorithm.cc150.chapter2;

import java.util.HashSet;
import java.util.Set;

import algorithm.common.ListNode;


/**
 * Write code to remove duplicates from an unsorted linked list.
 * 
 * FOLLOW UP
 * 
 * How would you solve this problem if a temporary buffer is not allowed?
 * 
 */
//  O(1) space, O(n) time
public class Question1 {
  
  public void removeDuplicateWithoutBuffer(ListNode head) {
    // write implementation here
    if (head == null) {
      return;
    }
    ListNode cur = head;
    ListNode nextDiff = cur.next;
    while (nextDiff != null) {
      if (cur.val != nextDiff.val) {
        cur.next = nextDiff;
        cur = nextDiff;
      }
      nextDiff = nextDiff.next;
    }
    cur.next = null;
  }

}
