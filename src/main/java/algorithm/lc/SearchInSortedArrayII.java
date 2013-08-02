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
public class SearchInSortedArrayII {

  public class Solution {
    public boolean search(int[] A, int target) {
      // Start typing your Java solution below
      // DO NOT write main() function
      int left = 0, right = A.length - 1;

      while (left <= right) {
        int mid = (left + right) / 2;
        if (A[mid] == target) {
          return true;
        }

        if (A[mid] < target) {
          if (A[right] < A[mid] || target <= A[right]) {
            left = mid + 1;
          } else if (A[mid] < A[right] && A[right] < target) {
            right = mid - 1;
          } else {
            --right;
          }
        } else {
          if (A[mid] < A[right] || A[right] < target) {
            right = mid - 1;
          } else if (A[right] < A[mid] && target <= A[right]) {
            left = mid + 1;
          } else {
            --right;
          }
        }

      }

      return false;
    }
  }

}
