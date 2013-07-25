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
      // Start typing your Java solution below
      // DO NOT write main() function
      ListNode head = new ListNode(0);
      ListNode cur = head;

      while (true) {
        int min = Integer.MAX_VALUE;
        int minListIdx = -1;

        for (int i = 0; i < lists.size(); ++i) {
          ListNode node = lists.get(i);
          if (node != null) {
            if (node.val <= min) {
              min = node.val;
              minListIdx = i;
            }
          }
        }
        if (minListIdx != -1) {
          cur.next = lists.get(minListIdx);
          lists.set(minListIdx, lists.get(minListIdx).next);
          cur = cur.next;
        } else {
          break;
        }
      }
      return head.next;
    }
  }

}
