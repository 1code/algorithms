package algorithm.lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a digit string, return all possible letter combinations that the number
 * could represent.
 * 
 * 
 * Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd",
 * "ce", "cf"]. Note: Although the above answer is in lexicographical order,
 * your answer could be in any order you want.
 * 
 */
// O(4^n) space, O(4^n) time
public class LetterCombinationsOfAPhoneNumber {

  public class Solution {

    public ArrayList<String> letterCombinations(String number) {
      // Start typing your Java solution below
      // DO NOT write main() function

      Map<Character, String[]> table = new HashMap<Character, String[]>();
      table.put('0', new String[] { "" });
      table.put('1', new String[] { "" });
      table.put('2', new String[] { "a", "b", "c" });
      table.put('3', new String[] { "d", "e", "f" });
      table.put('4', new String[] { "g", "h", "i" });
      table.put('5', new String[] { "j", "k", "l" });
      table.put('6', new String[] { "m", "n", "o" });
      table.put('7', new String[] { "p", "q", "r", "s" });
      table.put('8', new String[] { "t", "u", "v" });
      table.put('9', new String[] { "w", "x", "y", "z" });

      ArrayList<String> res = new ArrayList<String>();
      res.add("");
      for (int i = 0; i < number.length(); ++i) {
        ArrayList<String> newRes = new ArrayList<String>();
        char curLetter = number.charAt(i);
        for (String str : res) {
          for (String chStr : table.get(curLetter)) {
            newRes.add(str + chStr);
          }
        }
        res = newRes;
      }

      return res;
    }
  }
}
