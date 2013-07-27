package algorithm.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * 
 * Note: All inputs will be in lower-case.
 * 
 */
// O(n) space, O(ndlgd) time, where d is the length of string.
public class Anagrams {

  public class Solution {
    // use a map to store build the index, where key is the signature and value
    // is the list of strings with the signature
    public ArrayList<String> anagrams(String[] strs) {
      // Start typing your Java solution below
      // DO NOT write main() function
      ArrayList<String> anagrams = new ArrayList<String>();

      Map<String, List<String>> map = new HashMap<String, List<String>>();
      for (String str : strs) {
        char[] chs = str.toCharArray();
        Arrays.sort(chs);
        String key = new String(chs);
        List<String> list = map.get(key);
        if (list == null) {
          list = new ArrayList<String>();
        }
        list.add(str);
        map.put(key, list);
      }

      for (Map.Entry<String, List<String>> entry : map.entrySet()) {
        List<String> list = entry.getValue();
        if (list.size() > 1) {
          for (String str : list) {
            anagrams.add(str);
          }
        }
      }

      return anagrams;
    }
  }

}
