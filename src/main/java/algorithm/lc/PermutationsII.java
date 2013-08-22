package algorithm.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * For example, [1,1,2] have the following unique permutations: [1,1,2],
 * [1,2,1], and [2,1,1].
 * 
 */
public class PermutationsII {

  public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
          // Start typing your Java solution below
          // DO NOT write main() function
      Arrays.sort(num);
      ArrayList<Integer> cur = new ArrayList<Integer>();
      for (int i : num) {
        cur.add(i);
      }
      ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
      res.add(new ArrayList<Integer>(cur));
      if (cur.size() <= 1) {
        return res;
      }
      while (next(cur)) {
        res.add(new ArrayList<Integer>(cur));
      }
      return res;
    }
    
    private boolean next(ArrayList<Integer> cur) {
      int lastSmaller = cur.size() - 2;
      while (cur.get(lastSmaller) >= cur.get(lastSmaller + 1)) {
        --lastSmaller;
        if (lastSmaller < 0) {
          return false;
        }
      }
      
      int firstBigger = cur.size() - 1;
      while (cur.get(firstBigger) <= cur.get(lastSmaller)) {
        -- firstBigger;
      }
      swap(cur, lastSmaller, firstBigger);
      ++lastSmaller;
      int last = cur.size() - 1;
      while (lastSmaller < last) {
        swap(cur, lastSmaller, last);
        ++lastSmaller;
        --last;
      }
      return true;
    }
    
    private void swap(List<Integer> list, int first, int second) {
      int tmp = list.get(first);
      list.set(first, list.get(second));
      list.set(second, tmp);
    }
  }
  
}
