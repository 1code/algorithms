package algorithm.basic;


public class BubbleSort extends Sort {

  // O(1) space, O(n^2) time
  // in each loop, the end part of the array is sorted
  public void sort(int[] A) {
    boolean swapped = true;
    while (swapped == true) {
      swapped = false;
      for (int i = 1; i < A.length; ++i) {
        if (A[i - 1] > A[i]) {
          swapped = true;
          int tmp = A[i - 1];
          A[i - 1] = A[i];
          A[i] = tmp;
        }
      }
    }
  }

}
