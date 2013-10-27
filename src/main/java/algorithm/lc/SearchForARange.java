package algorithm.lc;

import java.util.Arrays;

/**
 * Given a sorted array of integers, find the starting and ending position of a
 * given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * 
 */
// O(1) space, O(lgn) time
public class SearchForARange {

  public static class Solution {
    // use binary search twice
    public int[] searchRange(int[] A, int target) {
      // Start typing your Java solution below
      // DO NOT write main() function
      int start = -1, end = -1;
      int left = 0, right = A.length - 1;

      // search for start
      while (left <= right) {
        int mid = (left + right) / 2;
        if (target == A[mid]) {
          start = (start == -1 ? mid : Math.min(start, mid));
          right = mid - 1; // continue search left part
        } else if (target > A[mid]) {
          left = mid + 1;
        } else { // if target < A[mid]
          right = mid - 1;
        }
      }

      left = 0;
      right = A.length - 1;
      while (left <= right) {
        int mid = (left + right) / 2;
        if (target == A[mid]) {
          end = (end == -1 ? mid : Math.max(mid, end));
          left = mid + 1; // continue search right
        } else if (target > A[mid]) {
          left = mid + 1;
        } else { // target < A[mid]
          right = mid - 1;
        }
      }

      int[] res = { start, end };
      return res;
    }

  }
  
  public static void main(String[] args) {
    Solution s = new Solution();
    int[] A = {1};
    int target = 1;
    int[] res = s.searchRange(A, target);
    System.out.println(Arrays.toString(res));
  }

}
