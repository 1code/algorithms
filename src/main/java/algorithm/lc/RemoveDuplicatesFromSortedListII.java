package algorithm.lc;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * For example, Given 1->2->3->3->4->4->5, return 1->2->5. Given 1->1->1->2->3,
 * return 2->3.
 * 
 */
// O(1) space, O(n) time
public class RemoveDuplicatesFromSortedListII {

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public class Solution {
    // use three pointer
    // when current pointer equals to next pointer, move forward until no
    // duplicate
    public ListNode deleteDuplicates(ListNode head) {
      // Start typing your Java solution below
      // DO NOT write main() function

      ListNode fakeHead = new ListNode(0);
      ListNode prev = fakeHead;
      ListNode cur = head;

      while (cur != null) {
        ListNode next = cur.next;
        if (next == null) {
          prev.next = cur;
          break;
        } else if (cur.val == next.val) {
          int val = cur.val;
          do {
            cur = cur.next;
            next = next.next;
          } while (next != null && cur.val == val);
          if (cur.val == val) { // prev is the last one
            prev.next = null;
            break;
          } else {
            prev.next = cur;
          }
        } else if (cur.val != next.val) {
          prev.next = cur;
          prev = cur;
          cur = next;
        }
      }

      return fakeHead.next;
    }
  }
  
  

}
