package algorithm.basic;

public class SelectionSort extends Sort {
  
  // O(1) space, O(n^2) time
  // every time the part before the current element of the array is sorted
  public void sort(int[] A) {
    for (int i = 0; i < A.length; ++i) {
      int min = i;
      for (int j = i + 1; j < A.length; ++j) {
        if (A[j] < A[min]) {
          min = j;
        }
      }
      int tmp = A[min];
      A[min] = A[i];
      A[i] = tmp;
    }
  }

}
