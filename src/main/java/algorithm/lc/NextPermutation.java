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

  public static class Solution {
    // Conduct in 4 steps:
    // 1. find the last elem that is smaller than its next elem.
    // 2. find the last elem that is bigger than preivously found elem
    // 3. swap these two elems
    // 4. reverse the elems that appear after the elem found in 1.
    public void nextPermutation(int[] num) {
      // Start typing your Java solution below
      // DO NOT write main() function
      if (num.length == 1) {
        return;
      }
      int lastSmaller = num.length - 2;
      while (num[lastSmaller] >= num[lastSmaller + 1]) {
        --lastSmaller;
        if (lastSmaller < 0) {
          Arrays.sort(num);
          return;
        }
      }
      int lastBigger = num.length - 1;
      while (num[lastBigger] <= num[lastSmaller]) {
        --lastBigger;
      }
      swap(num, lastBigger, lastSmaller++);

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
  
  public static void main(String[] args) {
    int[] num = {2, 3, 1, 1, 1};
    Solution s = new Solution();
    s.nextPermutation(num);
    System.out.println(Arrays.toString(num));
    s.nextPermutation(num);
    System.out.println(Arrays.toString(num));
  }

}
