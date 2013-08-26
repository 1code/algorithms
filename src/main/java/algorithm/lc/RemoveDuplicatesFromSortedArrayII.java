package algorithm.lc;

/**
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most
 * twice?
 * 
 * For example, Given sorted array A = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 * 
 */
public class RemoveDuplicatesFromSortedArrayII {

  // O(n) space, O(n) time
  public class Solution {
    // check the previous two elements that are already in the partial results
    public int removeDuplicates(int[] A) {
      // Start typing your Java solution below
      // DO NOT write main() function
      if (A.length < 3) {
        return A.length;
      }
      int len = 2;
      for (int i = 2; i < A.length; ++i) {
        if (!(A[i] == A[len - 1] && A[i] == A[len - 2])) {
          A[len++] = A[i];
        }
      }
      return len;
    }
  }

}
