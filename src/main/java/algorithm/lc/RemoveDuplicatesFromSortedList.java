package algorithm.lc;

/**
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return 1->2->3.
 * 
 */
// O(1) space, O(n) time
public class RemoveDuplicatesFromSortedList {

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public class Solution {
    // three pointer to point to previous node, current node, and next node
    public ListNode deleteDuplicates(ListNode head) {
      // Start typing your Java solution below
      // DO NOT write main() function
      if (head == null) {
        return null;
      }
      ListNode pre = head;
      ListNode cur = head.next;
      while (cur != null) {
        if (cur.val == pre.val) {
          pre.next = cur.next;
          cur = cur.next;
        } else {
          pre = cur;
          cur = cur.next;
        }
      }
      return head;
    }
  }

}