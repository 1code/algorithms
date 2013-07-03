package algorithm.cc150.chapter2;

import java.util.Stack;

import algorithm.common.ListNode;

/**
 * Implement a function to check if a linked list is a palindrome.
 * 
 */
// O(n) space, O(n) time
public class Question7 {

  public boolean isPalindrome(ListNode head) {
    // write implementation here
    Stack<Integer> stack = new Stack<Integer>();
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      stack.push(slow.val);
      slow = slow.next;
      fast = fast.next.next;
    }
    // if list has odd number of elements
    if (fast != null) {
      slow = slow.next;
    }

    while (slow != null) {
      int top = stack.pop();
      if (slow.val != top) {
        return false;
      }
      slow = slow.next;
    }

    return true;
  }
}

