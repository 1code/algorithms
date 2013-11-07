package algorithm.lc;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to:
 * L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 */
public class ReorderList {

  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  /**
   * O(n) time, O(1) space. 
   *
   */
  public class Solution {
    
    public void reorderList(ListNode head) {
      // IMPORTANT: Please reset any member data you declared, as
      // the same Solution instance will be reused for each test case.
      ListNode cur = head;
      int size = 0;
      while (cur != null) {
        cur = cur.next;
        ++size;
      }
      if (size == 0) {
        return;
      }
      // decompose list into two
      int firstHalf = (size + 1) / 2;
      ListNode firstList = head;
      for (int i = 0; i < firstHalf - 1; ++i) {
        firstList = firstList.next;
      }
      ListNode secondList = firstList.next;
      firstList.next = null;
      firstList = head;

      // reverse secondList
      ListNode prev = null;
      cur = secondList;
      while (cur != null) {
        ListNode next = cur.next;
        cur.next = prev;
        prev = cur;
        cur = next;
      }
      // reset head of the second list
      secondList = prev;

      // concatenate two lists
      ListNode fakeHead = new ListNode(0);
      cur = fakeHead;
      ListNode curFirst = firstList;
      ListNode curSecond = secondList;
      boolean fromFirst = true;

      while (true) { // first list will always contains equal number or 1 more
                     // node than second list
        if (fromFirst) {
          cur.next = curFirst;
          curFirst = curFirst.next;
        } else {
          cur.next = curSecond;
          curSecond = curSecond.next;
        }
        fromFirst = !fromFirst;
        cur = cur.next;
        if (curFirst == null && curSecond == null) {
          break;
        }
      }

      head = fakeHead.next;
    }
  }

}
