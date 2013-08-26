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
      ListNode lessList = new ListNode(0);
      ListNode greaterEqualList = new ListNode(0);
      ListNode curLessList = lessList;
      ListNode curGreaterEqualList = greaterEqualList;
      
      ListNode cur = head;
      ListNode next;
      while (cur != null) {
        next = cur.next;
        cur.next = null;
        if (cur.val < x) {
          curLessList.next = cur;
          curLessList = curLessList.next;
        }
        else {
          curGreaterEqualList.next = cur;
          curGreaterEqualList = curGreaterEqualList.next;
        }
        cur = next;
      }
      curLessList.next = greaterEqualList.next;
      return lessList.next;
    }
  }

}