package algorithm.lc;

/**
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples. [1,3,5,6], 5 → 2 [1,3,5,6], 2 → 1 [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * 
 */
public class SearchInsertPosition {

  public class Solution {
    // binary search
    public int searchInsert(int[] A, int target) {
      // Start typing your Java solution below
      // DO NOT write main() function
      int left = 0, right = A.length - 1;
      while (left <= right) {
        int mid = (left + right) / 2;
        if (A[mid] == target) {
          return mid;
        } else if (A[mid] > target) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }

      return left;
    }
  }

}
