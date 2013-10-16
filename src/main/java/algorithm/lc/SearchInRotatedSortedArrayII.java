package algorithm.lc;

/**
 * Follow up for "Search in Rotated Sorted Array": What if duplicates are
 * allowed?
 * 
 * Would this affect the run-time complexity? How and why?
 * 
 * Write a function to determine if a given target is in the array.
 * 
 */
public class SearchInRotatedSortedArrayII {

  // O(1) space, O(n) time in worst case and O(lgn) in average
  public class Solution {
    public boolean search(int[] A, int target) {
      // Start typing your Java solution below
      // DO NOT write main() function
      int left = 0, right = A.length - 1;
      while (left <= right) {
        int mid = (left + right) / 2;
        if (target == A[mid]) {
          return true;
        }
        // skip duplicates
        while (left < mid && A[left] == A[mid]) {
          ++left;
        }

        if (A[left] <= A[mid]) { // left sorted
          if (A[left] <= target && target < A[mid]) { // in range
            right = mid - 1;
          } else {
            left = mid + 1;
          }
        } else { // right sorted
          if (A[mid] < target && target <= A[right]) {
            left = mid + 1;
          } else {
            right = mid - 1;
          }
        }
      }

      return false;
    }
  }

}
