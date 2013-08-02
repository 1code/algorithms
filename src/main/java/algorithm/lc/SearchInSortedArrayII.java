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
    // O(1) space, O(n) time, O(lgn) in average
    public boolean search(int[] A, int target) {
      // Start typing your Java solution below
      // DO NOT write main() function
      int start = 0;
      int end = A.length - 1;

      while (start <= end) {
        int mid = (start + end) / 2;
        if (A[mid] == target)
          return true;
        else if (A[start] == A[mid])
          start++;
        else if (A[start] < A[mid]) { // left sorted
          if (A[start] <= target && target < A[mid]) // in range of left
            end = mid - 1;
          else
            start = mid + 1;
        } else { // right sorted
          if (A[mid] < target && target <= A[end]) // in range of right
            start = mid + 1;
          else
            end = mid - 1;
        }
      }
      return false;
    }
  }

}
