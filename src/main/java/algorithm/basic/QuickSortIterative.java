package algorithm.basic;

public class QuickSortIterative extends Sort {
  
  public void sort(int[] A) {
    
    int[] stack = new int[64];
    int top = -1;
    stack[++top] = 0;
    stack[++top] = A.length - 1;
    
    while (top != -1) {
      int right = stack[top--];
      int left = stack[top--];
      if (left < right) {
        int pivot = pivot(A, left, right);
        if (pivot - left > right - pivot) {  // left longer, process right first
          stack[++top] = left;
          stack[++top] = pivot - 1;
          stack[++top] = pivot + 1;
          stack[++top] = right;
        }
        else { // right longer, process left first
          stack[++top] = pivot + 1;
          stack[++top] = right;
          stack[++top] = left;
          stack[++top] = pivot - 1;
        }
      }
    }
    
  }
  
  private int pivot(int[] A, int start, int end) {
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
