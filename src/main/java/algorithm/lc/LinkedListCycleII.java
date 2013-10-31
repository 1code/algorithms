package algorithm.lc;

public class LinkedListCycleII {

  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public class Solution {
    public ListNode detectCycle(ListNode head) {
      // IMPORTANT: Please reset any member data you declared, as
      // the same Solution instance will be reused for each test case.
      ListNode slow = head;
      ListNode fast = head;

      while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) { // fast meets slow
          break;
        }
      }

      if (fast == null || fast.next == null) { // there is no cycle
        return null;
      }

      // when slow reach the start of the loop with k step, fast already goes
      // for 2k steps, so it is k steps ahead of the start of the loop.
      
      // If they keep move at their original speed, they will meet k steps before the start of the loop,
      // Now move slow to the head of list, and make fast move with the speed of the slow (both with speed 1),
      // then their next meet will at the start of the cycle.
      
      slow = head;
      while (slow != fast) { // they will meet at the start of loop
        slow = slow.next;
        fast = fast.next;
      }

      return fast;
    }
  }

}
