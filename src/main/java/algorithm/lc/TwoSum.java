package algorithm.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 * 
 */
public class TwoSum {

  public class Solution {
    public int[] twoSum(int[] numbers, int target) {
      // Start typing your Java solution below
      // DO NOT write main() function
      Map<Integer, Integer> map = new HashMap<Integer, Integer>();
      for (int i = 0; i < numbers.length; ++i) {
        map.put(numbers[i], i + 1);
      }
      for (int i = 0; i < numbers.length; ++i) {
        Integer idx = map.get(target - numbers[i]);
        if (idx != null) {
          return new int[] { Math.min(i + 1, idx), Math.max(i + 1, idx) };
        }
      }
      return null;
    }
  }

}
