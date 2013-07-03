package algorithm.lc;

import java.util.Collection;
import java.util.Iterator;

import org.junit.Test;

import algorithm.TestBase;
import algorithm.lc.ReverseList2.ListNode;
import algorithm.lc.ReverseList2.Solution;
import algorithm.util.Utils;

public class TestReverseList2 extends TestBase {
  
  private ReverseList2.Solution solution;

  @Override
  protected void initInstance() {
    solution = new Solution();
  }

  @Override
  @Test
  public void testPosCase() {
    ListNode head = new ListNode(-1);
    head.next = new ListNode(-3);
    int m = 1;
    int n = 2;
    ListNode newHead = solution.reverseBetween(head, m, n);
    printCollection(newHead);
  }
  
  @Override
  @Test
  public void testNegCase() {
    //  no negative
  }
  
  private static void printCollection(ListNode head) {
    StringBuilder sb = new StringBuilder();
    while (head != null) {
      sb.append(head.val);
      sb.append(' ');
      head = head.next;
    }
    System.out.println(sb.toString());
  }

}
