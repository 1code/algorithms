package algorithm.lc;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * 
 * Note: You may assume that A has enough space to hold additional elements from
 * B. The number of elements initialized in A and B are m and n respectively.
 * 
 */
public class MergeSortedArray {

  // O(1) space, O(n) time
  public class Solution {
    public void merge(int A[], int m, int B[], int n) {
      // Start typing your Java solution below
      // DO NOT write main() function
      int i = m - 1;
      int j = n - 1;
      int k = A.length - 1;
      while (i >= 0 || j >= 0) {
        if (i < 0) {
          A[k--] = B[j--];
        } else if (j < 0) {
          A[k--] = A[i--];
        } else {
          A[k--] = A[i] > B[j] ? A[i--] : B[j--];
        }
      }
    }
  }

}
