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
      Map<Pair, Boolean> cache = new HashMap<Pair, Boolean>();
      return found(s, 0, s.length(), dict, cache);     
    }
    
    private boolean found(String s, int start, int end, Set<String> dict, Map<Pair, Boolean> cache) {
      if (start >= end) {
        return false;
      }
      // check from memorization
      Boolean res = cache.get(new Pair(start, end));
      if (res != null) {
        return res;
      }
      // calculate from scratch
      if (dict.contains(s.substring(start, end))) {
        cache.put(new Pair(start, end), true);
        return true;
      }
      else { 
        for (int i = start + 1; i < end; ++i) {
          if (found(s, start, i, dict, cache) && found(s, i, end, dict, cache)) {
            cache.put(new Pair(start, end), true);
            return true;
          }
        }
        cache.put(new Pair(start, end), false);
        return false;
      }
    }
    
    private class Pair {
      int start;
      int end;
      
      public Pair(int start, int end) {
        this.start = start;
        this.end = end;
      }
      
      public boolean equals(Object o) {
        if (o instanceof Pair) {
          Pair other = (Pair)o;
          return this.start == other.start && this.end == other.end;
        }
        return false;
      }
      
      public int hashCode() {
        return this.start * (this.end * 11);
      }
    }
  }

}
