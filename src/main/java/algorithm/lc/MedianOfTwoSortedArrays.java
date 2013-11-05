package algorithm.lc;

/**
 * There are two sorted arrays A and B of size m and n respectively. Find the
 * median of the two sorted arrays. The overall run time complexity should be
 * O(log (m+n)).
 * 
 */
public class MedianOfTwoSortedArrays {

  /**
   * O(log(n + m)) time, O(1) space.
   * Each time remove a half of an array
   */
  public static class Solution {
    public double findMedianSortedArrays(int a[], int b[]) {
      // Start typing your Java solution below
      // DO NOT write main() function
      int m = a.length;
      int n = b.length;
      int total = m + n;
      if ((total % 2) == 1) {
        return findKth(a, 0, m - 1, b, 0, n - 1, total / 2 + 1);
      } else {
        return (findKth(a, 0, m - 1, b, 0, n - 1, total / 2) 
            + findKth(a, 0, m - 1, b, 0, n - 1, total / 2 + 1)) / 2;           
      }
    }
    
    public double findKth(int[] A, int[] B, int k) {
      return findKth(A, 0, A.length - 1, B, 0, B.length - 1, k);
    }
    
    // each time remove half of an array
    private double findKth(int[] A, int leftA, int rightA, int[] B, int leftB, int rightB, int k) {
      if (leftA > rightA) { // A is empty
        return B[leftB + k - 1]; // return the k - 1th in B
      }
      else if (leftB > rightB) {
        return A[leftA + k - 1];
      }
      
      int midA = (leftA + rightA) / 2;
      int midB = (leftB + rightB) / 2;
      
      // number of elements smaller than or equal to the larger of A[midA] and B[midB]
      int numFirstHalf = midA - leftA + midB - leftB + 2; 
      // compare the middle two element
      if (A[midA] > B[midB]) { 
        if (k < numFirstHalf) { // remove the second half of A
          return findKth(A, leftA, midA - 1, B, leftB, rightB, k);
        }
        else { // remove the first half of B
          return findKth(A, leftA, rightA, B, midB + 1, rightB, k - (midB + 1 - leftB));
        }
      }
      else {
        if (k < numFirstHalf) { // remove the second half of B
          return findKth(A, leftA, rightA, B, leftB, midB - 1, k); 
        }
        else { // remove the first half of A
          return findKth(A, midA + 1, rightA, B, leftB, rightB, k - (midA + 1 - leftA));
        }
      }
    }
    
  }

}
