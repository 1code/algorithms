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
    int start = 0, end = A.length - 1;
    
    int pivot = -1;
    while (pivot != k) {
      pivot = pivotHoare(A, start, end);
      if (pivot == k) {
        return A[k];
      }
      else if (pivot < k) {
        start = pivot + 1;
      }
      else {
        end = pivot - 1;
      }
    }
    
    return A[pivot];
  }
  
  private int findKth(int[] A, int k, int start, int end) {
    int pivot = pivotHoare(A, start, end);
    
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
  
  private int pivotHoare(int[] A, int start, int end) {
    int i = start, j = end + 1;
    int val = A[start];
    while (true) {
      while (A[++i] < val) {
        if (i == end) {
          break;
        }
      }
      
      while (val < A[--j]) {
        if (j == start) {
          break;
        }
      }
      
      if (i >= j) {
        break;
      }
      
      int tmp = A[i];
      A[i] = A[j];
      A[j] = tmp;
    }
    
    int tmp = A[j];
    A[j] = A[start];
    A[start] = tmp;
    return j;
  }

}
