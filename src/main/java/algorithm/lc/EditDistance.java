package algorithm.lc;

/**
 * Given two words word1 and word2, find the minimum number of steps required to
 * convert word1 to word2. (each operation is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * a) Insert a character 
 * b) Delete a character 
 * c) Replace a character
 * 
 */
public class EditDistance {
  // O(mn) space, O(mn) time
  public class Solution {
    // 2D DP
    public int minDistance(String word1, String word2) {
      // Start typing your Java solution below
      // DO NOT write main() function
      int[][] dist = new int[word1.length() + 1][word2.length() + 1];
      for (int i = 0; i < dist.length; ++i) {
        for (int j = 0; j < dist[i].length; ++j) {
          if (i == 0 || j == 0) {
            dist[i][j] = i != 0 ? i : j;
          } else {
            int plus = word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1;
            dist[i][j] = Math.min(dist[i - 1][j - 1] + plus,
                Math.min(dist[i - 1][j], dist[i][j - 1]) + 1);
          }
        }
      }

      return dist[word1.length()][word2.length()];
    }
  }

}
