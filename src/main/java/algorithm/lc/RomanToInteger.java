package algorithm.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a Roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 */
// O(1) space, O(n) time
public class RomanToInteger {

  public class Solution {
    public int romanToInt(String s) {
      // Start typing your Java solution below
      // DO NOT write main() function
      if (s.length() == 0) {
        return 0;
      }
      Map<Character, Integer> map = new HashMap<Character, Integer>();
      map.put('I', 1);
      map.put('V', 5);
      map.put('X', 10);
      map.put('L', 50);
      map.put('C', 100);
      map.put('D', 500);
      map.put('M', 1000);

      int prev = map.get(s.charAt(0));
      int res = prev;
      for (int i = 1; i < s.length(); ++i) {
        int value = map.get(s.charAt(i));
        if (value > prev) { // current unit is bigger than previousC
          res += value - 2 * prev;
        } else {
          res += value;
        }
        prev = value;
      }
      
      return res;
    }
  }

}
