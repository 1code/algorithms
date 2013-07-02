package algorithm.cc150.chapter2;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

import algorithm.TestBase;
import algorithm.common.ListNode;
import algorithm.util.Utils;

/**
 * Implement an algorithm to delete a node in the middle of a singly linked
 * list, given only access to that node.
 * 
 * 
 * EXAMPLE
 * 
 * Input: the node c from the linked list a ->b ->c ->d ->e
 * 
 * Result: nothing is returned, but the new linked list looks like a ->b ->d ->e
 * 
 */
public class TestQuestion3 extends TestBase {

  private Question3 question;

  @Override
  protected void initInstance() {
    question = new Question3();
  }

  @Override
  @Test
  public void testPosCase() {

    Random rnd = new Random();

    // create list
    int[] arr1 = {1, 2, 3, 4, 5};
    int[] expectArr1 = {1, 2, 4, 5};
    ListNode list1 = ListNode.arrayToList(arr1);
    ListNode expectList1 = ListNode.arrayToList(expectArr1);
    
    ListNode newHead1 = question.deleteMiddle(list1);
    assertTrue(ListNode.listEqual(expectList1, newHead1));

    int[] arr2 = {1, 2, 3, 4};
    int[] expectArr2 = {1, 4};
    ListNode list2 = ListNode.arrayToList(arr2);
    ListNode expectList2 = ListNode.arrayToList(expectArr2);
    
    ListNode newHead2 = question.deleteMiddle(list2);
    assertTrue(ListNode.listEqual(expectList2, newHead2));
    
    int[] arr3 = {1, 2};
    int[] expectArr3 = {};
    ListNode list3 = ListNode.arrayToList(arr3);
    ListNode expectList3 = ListNode.arrayToList(expectArr3);
    
    ListNode newHead3 = question.deleteMiddle(list3);
    assertTrue(ListNode.listEqual(expectList3, newHead3));
  }

  @Override
  @Test
  public void testNegCase() {
    // no positive case
  }

}
