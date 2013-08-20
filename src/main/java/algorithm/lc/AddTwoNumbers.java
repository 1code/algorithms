package algorithm.lc;

/**
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * 
 */
public class AddTwoNumbers {

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  // O(n) space, O(n) time
  public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      // Start typing your Java solution below
      // DO NOT write main() function
      ListNode head = new ListNode(0);
      ListNode cur = head;
      int carry = 0;
      while (l1 != null || l2 != null) {
        int digit = carry;
        if (l1 != null) {
          digit += l1.val;
          l1 = l1.next;
        }
        if (l2 != null) {
          digit += l2.val;
          l2 = l2.next;
        }
        carry = digit / 10;
        digit %= 10;
        cur.next = new ListNode(digit);
        cur = cur.next;
      }
      if (carry == 1) {
        cur.next = new ListNode(carry);
      }
      return head.next;
    }
  }

}
