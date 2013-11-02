package algorithm.dp;

/**
 * Find out the longest strictly increasing subsequence from the given array.
 *
 * e.g.
 * For array:  0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15,
 * the longest increaseing subsequence is: 0, 2, 6, 9, 13, 15.
 */
public class LongestIncreasingSubsequence {
  
  /**
   * Basic DP, time complexity O(n^2), space complexity O(n)
   * 
   * Suppose len[i] records the LIS end at i, then
   *           
   * len[i] = len[j] + 1, for j < i and arr[j] < arr[i] 
   * or 1 if arr[i] smaller or equal than all its predecessor.
   * 
   * @param arr
   * @return
   */
  public int lis(int[] arr) {
    int[] len = new int[arr.length];
    len[0] = 1;
    int maxLen = 0;
    for (int i = 1; i < arr.length; ++i) {
      len[i] = 1;
      for (int j = 0; j < i; ++j) {
        if (arr[i] > arr[j] && len[j] + 1 > len[i]) {
          len[i] = len[j] + 1;
        }
      }
      maxLen = Math.max(maxLen, len[i]); // keep the longest one
    }
    
    return maxLen;
  }
  
}
