package algorithm.lc;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a collection of numbers, return all possible permutations.
 * 
 * For example, [1,2,3] have the following permutations: [1,2,3], [1,3,2],
 * [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 */
// O(n!) space, O(n!) time, where n is the length of array
public class Permutations {

  public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
      // Start typing your Java solution below
      // DO NOT write main() function
      ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
      ArrayList<Integer> cur = new ArrayList<Integer>();
      Arrays.sort(num);
      for (int i : num) {
        cur.add(i);
      }
      do {
        res.add(cur);
      } while (nextPermutation(cur));
      return res;
    }

    private boolean nextPermutation(ArrayList<Integer> list) {
      int lastSmaller = -1;
      // find the last elem that is less than its next elem
      for (int i = list.size() - 2; i >= 0; --i) {
        if (list.get(i) <= list.get(i + 1)) {
          lastSmaller = i;
          break;
        }
      }
      if (lastSmaller == -1) {
        return false; // already the last permutation
      }

      int lastBigger = list.size() - 1;
      // find the last elem that is bigger than list.get(lastSmaller)
      for (; lastBigger >= 1; --lastBigger) {
        if (list.get(lastBigger) > list.get(lastSmaller)) {
          break;
        }
      }
      // swap
      int tmp = list.get(lastBigger);
      list.set(lastBigger, list.get(lastSmaller));
      list.set(lastSmaller, tmp);
      ++lastSmaller;
      // reverse
      int last = list.size() - 1;
      while (lastSmaller < last) {
        tmp = list.get(lastSmaller);
        list.set(lastSmaller, list.get(last));
        list.set(last, tmp);
        ++lastSmaller;
        --last;
      }
      return true;
    }
  }
  
}
