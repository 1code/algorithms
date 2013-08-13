package algorithm.lc;

import java.util.Arrays;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, We get the
 * following sequence (ie, for n = 3):
 * 
 * "123" "132" "213" "231" "312" "321"
 * 
 * Given n and k, return the kth permutation sequence.
 * 
 * Note: Given n will be between 1 and 9 inclusive.
 * 
 */
// O(n) space, O(kn) time
public class PermutationSequence {

  public class Solution {
    public String getPermutation(int n, int k) {
      // Start typing your Java solution below
      // DO NOT write main() function
      int[] num = new int[n];
      for (int i = 0; i < n; ++i) {
        num[i] = i + 1;
      }

      for (int i = 1; i < k; ++i) {
        next(num);
      }
      StringBuilder sb = new StringBuilder();
      for (int v : num) {
        sb.append(v);
      }
      return sb.toString();
    }

    private void next(int[] num) {
      int lastSmallIdx = num.length - 2;
      while (num[lastSmallIdx] >= num[lastSmallIdx + 1]) {
        --lastSmallIdx;
      }
      if (lastSmallIdx == -1) {
        Arrays.sort(num);
        return; // no next permutation
      }
      int lastElementLargerIdx = num.length - 1;
      while (num[lastElementLargerIdx] <= num[lastSmallIdx]) {
        --lastElementLargerIdx;
      }
      swap(num, lastElementLargerIdx, lastSmallIdx);
      ++lastSmallIdx;
      int last = num.length - 1;
      while (lastSmallIdx < last) {
        swap(num, lastSmallIdx, last);
        ++lastSmallIdx;
        --last;
      }
    }

    private void swap(int[] num, int first, int second) {
      int tmp = num[first];
      num[first] = num[second];
      num[second] = tmp;
    }
  }

}
