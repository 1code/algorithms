package algorithm.lc;

/**
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up: Can you solve it without using extra space?
 * 
 */
public class LinkedListCycle {

  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public class Solution {
    public boolean hasCycle(ListNode head) {
      // IMPORTANT: Please reset any member data you declared, as
      // the same Solution instance will be reused for each test case.
      ListNode fast = head;
      ListNode slow = head;

      while (fast != null) {
        slow = slow.next;
        fast = fast.next;
        if (fast == null || fast.next == null) { // fast reaches to the end of
                                                 // list
          return false;
        }
        fast = fast.next;

        if (fast == slow) { // fast meets slow
          return true;
        }
      }

      return false;
    }
  }

}
