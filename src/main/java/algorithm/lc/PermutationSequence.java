package algorithm.lc;


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
      for (int i : num) {
        sb.append(i);
      }
      return sb.toString();
    }
    
    private void next(int[] num) {
      if (num.length == 1) {
        return;
      }
      int lastSmaller = num.length - 2;
      while (num[lastSmaller] >= num[lastSmaller + 1]) {
        --lastSmaller;
        if (lastSmaller < 0) {
          return;
        }
      }
      int lastBigger = num.length - 1;
      while (num[lastBigger] <= num[lastSmaller]) {
        --lastBigger;
      }
      swap(num, lastSmaller++, lastBigger);
      int last = num.length - 1;
      while (lastSmaller < last) {
        swap(num, lastSmaller++, last--);
      }
    }
    
    private void swap(int[] num, int first, int second) {
      int tmp = num[first];
      num[first] = num[second];
      num[second] = tmp;
    }
  }

}
