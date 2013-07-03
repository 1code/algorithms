package algorithm.cc150.chapter2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

import algorithm.TestBase;
import algorithm.common.ListNode;
import algorithm.util.Utils;

/**
 * Implement a function to check if a linked list is a palindrome.
 * 
 */
public class TestQuestion7 extends TestBase {

  private Question7 question;

  @Override
  protected void initInstance() {
    question = new Question7();
  }

  @Override
  @Test
  public void testPosCase() {
    // test empty
    ListNode empty = null;
    assertTrue(question.isPalindrome(empty));

    // with only one element
    Random rnd = new Random();
    ListNode one = new ListNode(rnd.nextInt());
    assertTrue(question.isPalindrome(one));

    // palindrome with even elements
    ListNode headEven = new ListNode(0);
    ListNode cur = headEven;
    for (int i = 0; i < 5; ++i) {
      cur.next = new ListNode(i);
      cur = cur.next;
    }

    for (int i = 0; i < 5; ++i) {
      cur.next = new ListNode(5 - i - 1);
      cur = cur.next;
    }
    cur.next = new ListNode(0);
    assertTrue(question.isPalindrome(headEven));

    // palindrome with odd elements
    ListNode headOdd = new ListNode(0);
    cur = headOdd;
    for (int i = 0; i < 5; ++i) {
      cur.next = new ListNode(i);
      cur = cur.next;
    }
    cur.next = new ListNode(rnd.nextInt());
    cur = cur.next;
    for (int i = 0; i < 5; ++i) {
      cur.next = new ListNode(5 - i - 1);
      cur = cur.next;
    }
    cur.next = new ListNode(0);
    assertTrue(question.isPalindrome(headOdd));
  }

  @Override
  @Test
  public void testNegCase() {
    ListNode head = new ListNode(0);
    ListNode cur = head;
    for (int i = 1; i < 10; ++i) {
      cur.next = new ListNode(i);
      cur = cur.next;
    }
    assertFalse(question.isPalindrome(head));
  }

}
