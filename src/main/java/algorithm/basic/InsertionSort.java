package algorithm.basic;

public class InsertionSort extends Sort {
  
  public void sort(int[] A) {
    for (int i = 1; i < A.length; ++i) {
      int hole = i;
      int item = A[hole];
      while (hole > 0 && A[hole - 1] > item) {
        A[hole] = A[hole - 1];
        --hole;
      }
      A[hole] = item;
    }
  }

}
