package algorithm.lc;

import java.util.ArrayList;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 */
// O(\sum_{i} n_i) space, O(\sum_{i} n_i) time
public class MergeKSortedLists {

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
          // Note: The Solution object is instantiated only once and is reused by each test case.
      ListNode fakeHead = new ListNode(0);
      ListNode cur = fakeHead;
      
      while (true) {
        int index = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < lists.size(); ++i) { // find the minimum
          if (lists.get(i) != null && lists.get(i).val < min) {
            min = lists.get(i).val;
            index = i;
          }
        }
        
        if (index == -1) {
          return fakeHead.next;
        }
        // update pointers
        cur.next = lists.get(index);
        cur = cur.next;
        lists.set(index, lists.get(index).next);
      }
      
    }
  }

}
