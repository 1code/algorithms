package algorithm.lc;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (start and end), and a dictionary, find the length of
 * shortest transformation sequence from start to end, such that:
 * 
 * Only one letter can be changed at a time Each intermediate word must exist in
 * the dictionary For example,
 * 
 * Given: start = "hit" end = "cog" dict = ["hot","dot","dog","lot","log"]
 * 
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * Note:
 * 
 * Return 0 if there is no such transformation sequence. All words have the same
 * length. All words contain only lowercase alphabetic characters.
 * 
 */
// O(n) space, O(n) time
public class WordLadder {
  // BFS, enqueue all unvisited neighbors of current string
  public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
          // Start typing your Java solution below
          // DO NOT write main() function
      Queue<Pair> queue = new LinkedList<Pair>();
      Set<String> visited = new HashSet<String>();
      queue.offer(new Pair(start, 1));
      visited.add(start);
      
      while (!queue.isEmpty()) {
        Pair pair = queue.poll();
        char[] curChars = pair.word.toCharArray();
        int dist = pair.dist;
        for (int i = 0; i < curChars.length; ++i) { // substitute each char
          char tmp = curChars[i];
          for (char c = 'a'; c <= 'z'; ++c) {
            if (c == tmp) {
              continue;
            }
            curChars[i] = c;  
            String newStr = new String(curChars);
            if (newStr.equals(end)) {
              return dist + 1;
            }
            if (dict.contains(newStr) && !visited.contains(newStr)) {
              queue.offer(new Pair(newStr, dist + 1));
              visited.add(newStr);
            }
            curChars[i] = tmp;
          }
        }
      }
      return 0;
    }
    
    public class Pair {
      String word;
      int dist;
      public Pair(String word, int dist) {
        this.word = word;
        this.dist = dist;
      }
    }
  }

}
