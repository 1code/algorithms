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

  public class Solution {
    // use two pointer to record the current check position and the last
    // available slot
    public int removeElement(int[] A, int elem) {
      // Start typing your Java solution below
      // DO NOT write main() function
      int i = 0;
      int last = A.length - 1;
      int len = 0;
      while (i <= last) {
        if (A[i] == elem) {
          int tmp = A[last];
          A[last] = A[i];
          A[i] = tmp;
          --last;
        } else {
          ++i;
          ++len;
        }
      }
      return len;
    }
  }

}
