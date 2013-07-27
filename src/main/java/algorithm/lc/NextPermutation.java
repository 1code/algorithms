package algorithm.lc;

import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (i.e, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column. 
 * 
 * 1,2,3 → 1,3,2
 * 
 * 3,2,1 → 1,2,3
 * 
 * 1,1,5 → 1,5,1
 * 
 */
// O(1) space, O(n) time, n is the length of array
public class NextPermutation {

  public class Solution {
    // Conduct in 4 steps:
    // 1. find the last elem that is smaller than its next elem.
    // 2. find the last elem that is bigger than preivously found elem
    // 3. swap these two elems
    // 4. reverse the elems that appear after the elem found in 1.
    public void nextPermutation(int[] num) {
          // Start typing your Java solution below
          // DO NOT write main() function
      int lastSmaller = -1;
      // find the last elem that is smaller than its next elem
      for (int i = num.length - 2; i >= 0; --i) {
        if (num[i] < num[i + 1]) {
          lastSmaller = i;
          break;
        }
      }
      
      if (lastSmaller == -1) {
        Arrays.sort(num);
        return;
      }
      
      // find the last elem that is bigger than num[lastSmaller]
      int lastBigger = num.length - 1;
      for (; lastBigger > 0; --lastBigger) {
        if (num[lastBigger] > num[lastSmaller]) {
          break;
        }
      }
      
      // swap
      int tmp = num[lastBigger];
      num[lastBigger] = num[lastSmaller];
      num[lastSmaller] = tmp;
      ++lastSmaller;
      
      // reverse all the elements from lastSmaller to the end
      int last = num.length - 1;
      while (lastSmaller < last) {
        tmp = num[last];
        num[last] = num[lastSmaller];
        num[lastSmaller] = tmp;
        ++lastSmaller;
        --last;
      }

    }
  }

}
