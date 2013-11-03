package algorithm.basic;

public class BinarySearch {
  
  /**
   * The version in JDK. If no answer found, return (-(insertion point) - 1).
   * @param A
   * @param target
   * @return
   */
  public int binarySearch(int[] A, int target) {
    int start = 0, end = A.length - 1;
    while (start <= end) {
      int mid = (start + end) >>> 1;
      if (A[mid] < target) {
        start = mid + 1;
      }
      else if (A[mid] > target) {
        end = mid - 1;
      }
      else {
        return mid;
      }
    }
    return -(start + 1);
  }

}
