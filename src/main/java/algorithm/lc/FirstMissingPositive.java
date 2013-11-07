package algorithm.lc;


/**
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 */
public class FirstMissingPositive {

  //O(n) space, O(n) time
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
  
  // O(1) space, O(n) time
  // switch each val to appropriate position A[val - 1]
  public class Solution2 {
    public int firstMissingPositive(int[] A) {
          // Note: The Solution object is instantiated only once and is reused by each test case.
      int i = 0;
      while (i < A.length) {
        // move A[i] to appropriate position
        if (A[i] > 0 && A[i] <= A.length 
            && A[A[i] - 1] != A[i] // two swap numbers are not equal
            && A[i] != i + 1) {  // current number is not in appropriate location
          int tmp = A[i];
          int idx = A[i] - 1;
          A[i] = A[idx];
          A[idx] = tmp;
        }
        else {
          ++i; // skip number not in range
        }
      }
      
      for (i = 0; i < A.length; ++i) {
        if (A[i] != i + 1) {
          break;
        }
      }
      return i + 1;
    }
  }

}
