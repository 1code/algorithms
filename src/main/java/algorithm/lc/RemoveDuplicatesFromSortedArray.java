package algorithm.lc;

/**
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 * 
 * For example, Given input array A = [1,1,2],
 * 
 * Your function should return length = 2, and A is now [1,2].
 * 
 */
public class RemoveDuplicatesFromSortedArray {

  public class Solution {
    // two pointers, i move forward, j point to the last valid element
    public int removeDuplicates(int[] A) {
      // Start typing your Java solution below
      // DO NOT write main() function
      if (A == null) {
        return 0;
      }
      if (A.length < 2) {
        return A.length;
      }
      int i = 1;
      int j = 1;
      while (i < A.length) {
        if (A[i - 1] == A[i]) {
          ++i;
        } else {
          A[j++] = A[i++];
        }
      }
      return j;
    }
  }

}
