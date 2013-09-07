package algorithm.lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given a string, S, and a list of words, L, that are all of the same
 * length. Find all starting indices of substring(s) in S that is a
 * concatenation of each word in L exactly once and without any intervening
 * characters.
 * 
 * For example, given: S: "barfoothefoobarman" L: ["foo", "bar"]
 * 
 * You should return the indices: [0,9]. (order does not matter).
 * 
 */
// O(mn) space, O(ns) time, where m indicates the length of each word, n
// indicates the number of words, and s indicates the length of S
public class SubstringWithConcatenationOfAllWords {

  public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
          // Start typing your Java solution below
          // DO NOT write main() function
      ArrayList<Integer> res = new ArrayList<Integer>();
      if (L.length == 0) {
        return res;
      }
      Map<String, Integer> needs = new HashMap<String, Integer>();
      for (String word : L) {
        Integer count = needs.get(word);
        count = count == null? 1 : count + 1;
        needs.put(word, count);
      }
      
      int wordLen = L[0].length();
      int totalLen = wordLen * L.length;
      for (int i = 0; i <= S.length() - totalLen; ++i) {
        Map<String, Integer> has = new HashMap<String, Integer>();
        int j = 0;
        for (j = 0; j < L.length; ++j) { // check the candidates one by one
          String part = S.substring(i + j * wordLen, i + j * wordLen + wordLen);
          Integer count = needs.get(part);
          if (count == null) {  // needs dose not contain the word
            break;
          }
          Integer hasCount = has.get(part);
          hasCount = hasCount == null? 1 : hasCount + 1;
          if (hasCount > count) {
            break;
          }
          has.put(part, hasCount);
        }
        if (j == L.length) {
          res.add(i);
        }
      }
      return res;
    }
  }

}