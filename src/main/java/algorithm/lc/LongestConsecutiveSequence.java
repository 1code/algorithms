package algorithm.lc;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence. For example, Given [100, 4, 200, 1, 3, 2], The
 * longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 * 
 */
// O(n) space, O(n) time
public class LongestConsecutiveSequence {

  public class Solution {
    // add all elements to set, and check each element by removing its neighbors
    public int longestConsecutive(int[] num) {
      // Start typing your Java solution below
      // DO NOT write main() function
      Set<Integer> set = new HashSet<Integer>();
      for (int i : num) {
        set.add(i);
      }
      int max = 0;
      for (int i : num) {
        int left = i - 1;
        int right = i + 1;
        int count = 1;
        while (set.contains(left)) {
          set.remove(left--);
          ++count;
        }
        while (set.contains(right)) {
          set.remove(right++);
          ++count;
        }
        max = Math.max(max, count);
      }
      return max;
    }
  }

}
