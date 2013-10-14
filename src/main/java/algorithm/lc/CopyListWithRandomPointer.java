package algorithm.lc;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

  static class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
      this.label = x;
    }
  };

  public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
          // Note: The Solution object is instantiated only once and is reused by each test case.
      Map<Integer, RandomListNode> map = new HashMap<Integer, RandomListNode>(100);
      RandomListNode fakeHead = new RandomListNode(0);
      fakeHead.next = head;
      RandomListNode newFakeHead = new RandomListNode(0);
      RandomListNode curNode = fakeHead;
      RandomListNode curCopy = newFakeHead;
      
      // copy list without random pointers
      while (curNode.next != null) {
        curCopy.next = new RandomListNode(curNode.next.label);
        map.put(curNode.next.label, curCopy.next);
        curNode = curNode.next;
        curCopy = curCopy.next;
      }
      
      curNode = fakeHead.next;
      curCopy = newFakeHead.next;
      // add random pointers to each node
      while (curNode != null) {
        if (curNode.random != null) {
          curCopy.random = map.get(curNode.random.label);
        }
        curCopy = curCopy.next;
        curNode = curNode.next;
      }    
      
      return newFakeHead.next;
    }
    
  }

}
