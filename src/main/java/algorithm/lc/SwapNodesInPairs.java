package algorithm.lc;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values
 * in the list, only nodes itself can be changed.
 * 
 */
public class SwapNodesInPairs {

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  // O(1) space, O(n) time
  public class Solution {
    // use three pointer to traverse the list
    public ListNode swapPairs(ListNode head) {
      // Start typing your Java solution below
      // DO NOT write main() function
      ListNode fakeHead = new ListNode(0);
      fakeHead.next = head;
      ListNode prev = fakeHead;
      ListNode cur = fakeHead.next;

      while (cur != null) {
        ListNode next = cur.next;
        if (next != null) {
          cur.next = next.next;
          next.next = cur;
          prev.next = next;
          prev = cur;
        }
        cur = cur.next;
      }

      return fakeHead.next;
    }
  }

  // O(1) space, O(n) time
  public class Solution2 {
    public ListNode swapPairs(ListNode head) {
      // Start typing your Java solution below
      // DO NOT write main() function
      ListNode fakeHead = new ListNode(0);
      fakeHead.next = head;
      ListNode cur = fakeHead;
      ListNode slow;
      ListNode fast;
      while (true) {
        slow = cur;
        slow = slow.next;
        if (slow != null) {
          fast = slow.next;
        } else {
          break;
        }
        if (fast != null) {
          slow.next = fast.next;
          fast.next = slow;
          cur.next = fast;
        } else {
          break;
        }
        cur = slow;
      }
      return fakeHead.next;
    }
  }

}
