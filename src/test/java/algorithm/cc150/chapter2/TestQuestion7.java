package algorithm.cc150.chapter2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

import algorithm.TestBase;
import algorithm.cc150.chapter2.Question7.Node;

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
    //  test empty
    Node<Integer> empty = null;
    assertTrue(question.isPalindrome(empty));
    
    //  with only one element
    Random rnd = new Random();
    Node<Integer> one = new Node<Integer>(rnd.nextInt());
    assertTrue(question.isPalindrome(one));
    
    //  palindrome with even elements
    Node<Integer> headEven = null;
    Node<Integer> cur = headEven;
    for (int i = 0; i < 10; ++i) {
      cur = new Node<Integer>(i);
      cur = cur.next;
    }
    
    for (int i = 0; i < 10; ++i) {
      cur = new Node<Integer>(10 - i - 1);
      cur = cur.next;
    }
    assertTrue(question.isPalindrome(headEven));
    
    
    //  palindrome with odd elements
    Node<Integer> headOdd = null;
    cur = headOdd;
    for (int i = 0; i < 10; ++i) {
      cur = new Node<Integer>(i);
      cur = cur.next;
    }
    cur = new Node<Integer>(rnd.nextInt());
    cur = cur.next;
    for (int i = 0; i < 10; ++i) {
      cur = new Node<Integer>(10 - i - 1);
      cur = cur.next;
    }
    assertTrue(question.isPalindrome(headOdd));
  }

  @Override
  @Test
  public void testNegCase() {
    Node<Integer> head = null;
    Node<Integer> cur = head;
    for (int i = 0; i < 10; ++i) {
      cur = new Node<Integer>(i);
      cur = cur.next;
    }
    assertFalse(question.isPalindrome(head));
  }
  
  

}
