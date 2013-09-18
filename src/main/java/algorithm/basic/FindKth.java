package algorithm.basic;

public class FindKth {
  
  /**
   * 0-th smallest is the smallest. 
   * @param A
   * @param k
   * @return
   */
  public int findKth(int[] A, int k) {
    if (k < 0 || k >= A.length) {
      throw new IllegalArgumentException(String.format("k should be in range [0, %d]\n.", A.length));
    }
    return findKth(A, k, 0, A.length - 1);
  }
  
  private int findKth(int[] A, int k, int start, int end) {
    int pivot = pivot(A, start, end);
    
    if (pivot == k) {
      return A[pivot];
    }
    else if (pivot < k) {  // find the (k - pivot)-th from the second half
      return findKth(A, k, pivot + 1, end);
    }
    else { // pivot > k, find the k-th from the first half
      return findKth(A, k, start, pivot - 1);
    }
  }
  
  private int pivot(int[] A, int start, int end) {
    int pivot = A[end];
    int bar = start - 1;
    for (int i = start; i < end; ++i) {
      if (A[i] < pivot) {
        ++bar;
        int tmp = A[i];
        A[i] = A[bar];
        A[bar] = tmp;
      }
    }
    
    int tmp = A[bar + 1];
    A[bar + 1] = A[end];
    A[end] = tmp;
    return bar + 1;
  }

}
