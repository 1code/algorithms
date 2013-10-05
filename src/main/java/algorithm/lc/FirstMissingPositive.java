package algorithm.lc;


/**
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 */
// O(1) space, O(n) time
public class FirstMissingPositive {

  public static class Solution {
    // if size of A is n, create an boolean array with size n + 1,
    // the nth elements indicate whether the number n + 1 appears
    public int firstMissingPositive(int[] A) {
      // Start typing your Java solution below
      // DO NOT write main() function
      boolean[] exists = new boolean[A.length + 1];
      for (int i = 0; i < A.length; ++i) {
        if (A[i] > 0 && A[i] < exists.length) {
          exists[A[i] - 1] = true;
        }
      }

      for (int i = 0; i < exists.length; ++i) {
        if (!exists[i]) {
          return i + 1;
        }
      }

      return exists.length;
    }
  }
  
  public static void main(String[] args) {
    Solution s = new Solution();
    int[] A = {1};
    System.out.println(s.firstMissingPositive(A));
  }

}
