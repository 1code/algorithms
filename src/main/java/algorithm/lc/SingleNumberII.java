package algorithm.lc;

/**
 * Given an array of integers, every element appears three times except for one.
 * Find that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 * 
 */
public class SingleNumberII {

  // O(1) space, O(n) time
  public class Solution {
    public int singleNumber(int[] A) {
      // Note: The Solution object is instantiated only once and is reused by
      // each test case.
      int once = 0, twice = 0, threeTimes = 0;
      for (int val : A) {
        twice |= once & val; // record the bits that the val appears twice, is 0 for the first iteration
        once ^= val; // record the bits that the val appears once

        threeTimes = once & twice; // records the bits that val appear three times
        once &= ~threeTimes; // remove the bits that val appears three times
        twice &= ~threeTimes; // remove the bits that val appears three times
      }
      return once;
    }
  }

}
