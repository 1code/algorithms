package algorithm.lc;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WordBreak {
  
  // 2D DP, recursively divide a string into two parts to check.
  // O(n^2) space, O(n^2) time
  public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
          // Note: The Solution object is instantiated only once and is reused by each test case.
      Map<String, Boolean> cache = new HashMap<String, Boolean>();
      return found(s, 0, s.length(), dict, cache);     
    }
    
    private boolean found(String s, int start, int end, Set<String> dict, Map<String, Boolean> cache) {
      if (start >= end) {
        return false;
      }
      // check from memorization
      Boolean res = cache.get(s.substring(start, end));
      if (res != null) {
        return res;
      }
      // calculate from scratch
      if (dict.contains(s.substring(start, end))) {
        cache.put(s.substring(start, end), true);
        return true;
      }
      else { 
        for (int i = start + 1; i < end; ++i) {
          if (found(s, start, i, dict, cache) && found(s, i, end, dict, cache)) {
            cache.put(s.substring(start, end), true);
            return true;
          }
        }
        cache.put(s.substring(start, end), false);
        return false;
      }
    }
  }

}
