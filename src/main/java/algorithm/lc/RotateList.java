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

  public static class Solution {
    // use two pointer to find the kth node to the end, use it as the new head,
    // and add the old head as its next
    public static ListNode rotateRight(ListNode head, int n) {
      // Start typing your Java solution below
      // DO NOT write main() function
      if (head == null) {
        return head;
      }
      int size = 1;
      ListNode cur = head;
      while (cur.next != null) {
        ++size;
        cur = cur.next;
      }
      ListNode oldTail = cur;

      int k = n % size;
      if (k == 0) {
        return head;
      }

      int count = 0;
      ListNode fast = head;
      ListNode slow = head;
      while (fast != null && count < k) {
        fast = fast.next;
        ++count;
      }

      if (fast == null) {
        return head;
      }

      // when fast reaches to the end, slow is k from the end
      while (fast.next != null) {
        fast = fast.next;
        slow = slow.next;
      }

      ListNode fakeHead = new ListNode(0);

      fakeHead.next = slow.next; // create new head
      slow.next = null;
      oldTail.next = head;

      return fakeHead.next;
    }
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    ListNode next = new ListNode(2);
    head.next = next;
    int n = 1;
    ListNode res = Solution.rotateRight(head, n);
    while (res != null) {
      System.out.println(res.val);
      res = res.next;
    }
  }

}
