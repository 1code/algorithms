package algorithm.imagong;

import java.util.ArrayList;

/**
 * 给一个字典，里面有一堆词。然后给一个词，word，求返回，与word编辑距离<=1的所有出现在字典里的词。
 * 比如说{cat, fat, mat, at, yes, no}, word="cat"返回{cat, fat, mat, at}
 * 
 * interview@facebook
 */
public class EditDistanceII {

  /**
   * Time complexity O(kmn), k is the number of words in dict, 
   * m and n are the length of words in comparison.
   * 
   * Space complexity O(mn)
   */
  public class Solution {
    ArrayList<String> editDistanceII(ArrayList<String> dict, String word) {
      ArrayList<String> res = new ArrayList<String>();

      for (String dictWord : dict) {
        if (valid(dictWord, word)) {
          res.add(dictWord);
        }
      }

      return res;
    }

    // check whether two words has distance less than or equal to one
    private boolean valid(String word1, String word2) {
      int[][] dist = new int[word1.length() + 1][word2.length() + 2];

      for (int i = 0; i <= word1.length(); ++i) {
        for (int j = 0; j <= word2.length(); ++j) {
          if (i == 0 && j == 0) {
            dist[0][0] = 0;
          } else if (i == 0) {
            dist[i][j] = j;
          } else if (j == 0) {
            dist[i][j] = i;
          } else {
            int curDist = word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1;
            dist[i][j] = Math.min(Math.min(dist[i - 1][j], dist[i][j - 1]) + 1,
                dist[i - 1][j - 1] + curDist);
          }
        }
      }

      return dist[word1.length()][word2.length()] <= 1;
    }
  }

}
