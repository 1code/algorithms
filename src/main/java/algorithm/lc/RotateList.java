package algorithm.lc;

/**
 * Given a list, rotate the list to the right by k places, where k is
 * non-negative.
 * 
 * For example: Given 1->2->3->4->5->NULL and k = 2, return 4->5->1->2->3->NULL.
 * 
 */
// O(1) space, O(n) time
public class RotateList {

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public class Solution {
    // use two pointer to find the kth node to the end, use it as the new head,
    // and add the old head as its next
    public ListNode rotateRight(ListNode head, int n) {
      // Start typing your Java solution below
      // DO NOT write main() function
      if (head == null) {
        return null;
      }
      
      int size = 0;
      ListNode cur = head;
      while (cur != null) {
        ++size;
        cur = cur.next;
      }

      n = n % size;

      if (n == 0) { // no need to shift
        return head;
      }

      ListNode fast = head;
      int c = 0;
      while (fast != null && c++ < n) {
        fast = fast.next;
      }

      ListNode pre = head;
      while (fast.next != null) {
        pre = pre.next;
        fast = fast.next;
      }

      ListNode newHead = pre.next;

      fast.next = head;
      pre.next = null;
      return newHead;
    }
  }

}
