package algorithm.lc;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      // Start typing your Java solution below
      // DO NOT write main() function
      ListNode head = new ListNode(0);
      ListNode cur = head;
      while (l1 != null || l2 != null) {
        if (l1 == null || l2 != null && l1.val > l2.val) {
          cur.next = l2;
          l2 = l2.next;
        } else if (l2 == null || l1 != null && l1.val <= l2.val) {
          cur.next = l1;
          l1 = l1.next;
        }
        cur = cur.next;
      }

      return head.next;
    }
  }

}
