package algorithm.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer, convert it to a roman numeral.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 */
public class IntegerToRoman {

  public class Solution {
    public String intToRoman(int num) {
      // Start typing your Java solution below
      // DO NOT write main() function
      List<Pair> pairs = new ArrayList<Pair>();
      pairs.add(new Pair(1000, "M"));
      pairs.add(new Pair(900, "CM"));
      pairs.add(new Pair(500, "D"));
      pairs.add(new Pair(400, "CD"));
      pairs.add(new Pair(100, "C"));
      pairs.add(new Pair(90, "XC"));
      pairs.add(new Pair(50, "L"));
      pairs.add(new Pair(40, "XL"));
      pairs.add(new Pair(10, "X"));
      pairs.add(new Pair(9, "IX"));
      pairs.add(new Pair(5, "V"));
      pairs.add(new Pair(4, "IV"));
      pairs.add(new Pair(1, "I"));
      StringBuilder sb = new StringBuilder();
      for (Pair pair : pairs) {
        while (num >= pair.val) {
          sb.append(pair.symbol);
          num -= pair.val;
        }
      }
      return sb.toString();
    }

    public class Pair {
      int val;
      String symbol;

      public Pair(int val, String symbol) {
        this.val = val;
        this.symbol = symbol;
      }
    }
  }

}
