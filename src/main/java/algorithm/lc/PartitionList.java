package algorithm.lc;

/**
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 * 
 */
public class PartitionList {

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public class Solution {
    public ListNode partition(ListNode head, int x) {
      // Start typing your Java solution below
      // DO NOT write main() function
      ListNode lHead = new ListNode(0);
      ListNode geHead = new ListNode(0);
      ListNode lCur = lHead;
      ListNode geCur = geHead;
      ListNode cur = head;

      while (cur != null) {
        if (cur.val < x) {
          lCur.next = cur;
          lCur = lCur.next;
          cur = cur.next;
          lCur.next = null;
        } else {
          geCur.next = cur;
          geCur = geCur.next;
          cur = cur.next;
          geCur.next = null;
        }
      }

      lCur.next = geHead.next;
      return lHead.next;
    }
  }

}
