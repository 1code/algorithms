package algorithm.lc;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * 
 * If the number of nodes is not a multiple of k then left-out nodes in the end
 * should remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * 
 * Only constant memory is allowed.
 * 
 * For example, Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * 
 */
// O(1) space, O(n) time
public class ReverseNodesInKGroup {

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public class Solution {
    // reverse list in each local group, maintain the connection between
    // previous group to current group
    public ListNode reverseKGroup(ListNode head, int k) {
      // Start typing your Java solution below
      // DO NOT write main() function
      ListNode fakeHead = new ListNode(0);
      fakeHead.next = head;

      ListNode cur = head;
      ListNode prevGroupTail = fakeHead;
      while (cur != null) {
        // find the tail of current group
        int count = 1;
        ListNode groupHead = cur;
        ListNode groupTail = cur;
        while (groupTail.next != null && count < k) {
          groupTail = groupTail.next;
          ++count;
        }
        if (count < k) {
          prevGroupTail.next = groupHead;
          break; // reach the end of list
        }
        // reverse group
        ListNode groupPrev = null;
        for (int i = 0; i < k; ++i) {
          ListNode next = cur.next;
          cur.next = groupPrev;
          groupPrev = cur;
          cur = next;
        }
        // update inter-group links
        prevGroupTail.next = groupTail;
        prevGroupTail = groupHead;
      }
      
      return fakeHead.next;
    }
  }

}
