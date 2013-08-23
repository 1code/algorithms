package algorithm.lc;

/**
 * Given an array and a value, remove all instances of that value in place and
 * return the new length.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 * 
 */
public class RemoveElement {

  // O(1) space, O(n) time
  public class Solution {
    // use two pointer to record the current check position and the last
    // available slot
    public int removeElement(int[] A, int elem) {
      // Start typing your Java solution below
      // DO NOT write main() function
      int last = A.length - 1;
      int i = 0;
      while (i <= last) {
        if (A[i] == elem) {
          int tmp = A[i];
          A[i] = A[last];
          A[last--] = tmp;
        } else {
          ++i;
        }
      }
      return last + 1;
    }
  }

}
