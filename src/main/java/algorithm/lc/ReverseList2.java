package algorithm.lc;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4, return
 * 1->4->3->2->5->NULL.
 * 
 * Note: Given m, n satisfy the following condition: 1 ? m ? n ? length of list.
 * 
 * 
 */
public class ReverseList2 {

  public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public static class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
      // Start typing your Java solution below
      // DO NOT write main() function
      int len = n - m;
      ListNode fakeHead = new ListNode(0);
      fakeHead.next = head;
      ListNode prev = fakeHead;
      for (int i = 0; i < m - 1; ++i) {
        prev = prev.next;
      }
      
      ListNode before = prev;
      ListNode reverseHead = prev.next;
      ListNode cur = reverseHead;
      
      int count = 0;
      while (count++ <= len) {
        ListNode next = cur.next;
        cur.next = prev;
        prev = cur;
        cur = next;
      }
      reverseHead.next = cur;
      before.next = prev;

      return fakeHead.next;
    }
  }

}
