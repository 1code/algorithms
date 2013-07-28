package algorithm.lc;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * For example, Given board =
 * 
 * [ ["ABCE"], ["SFCS"], ["ADEE"] ] word = "ABCCED", -> returns true, word =
 * "SEE", -> returns true, word = "ABCB", -> returns false.
 * 
 */
public class WordSearch {
  
  public class Solution {

    public boolean exist(char[][] board, String word) {
      if(word.length() == 0) {
        return true;
      }
      int[][] used = new int[board.length][board[0].length];
      
      for(int i = 0; i < board.length; ++i) {
        for(int j = 0; j < board[0].length; ++j) {
          int cur = 0;
          if(word.charAt(cur) == board[i][j]) {
            if(find(board, word, i, j, cur, used)) {
              return true;
            }
          }
        }
      }
      return false;
    }

    private boolean find(char[][] board, String word, int i, int j, int cur, int[][] used) {
      
      if(used[i][j] == 1 || board[i][j] != word.charAt(cur)) {
        return false;
      }
      used[i][j] = 1;
      if(cur + 1 == word.length()) {
        return true;
      }
      // search up, right, down, and left
      if(i - 1 >= 0 && used[i - 1][j] == 0 && find(board, word, i - 1, j, cur + 1, used)) {
        return true;
      }
      if(j + 1 < board[0].length && used[i][j + 1] == 0 && find(board, word, i, j + 1, cur+1, used)) {
        return true;
      }
      if(i + 1 < board.length && used[i + 1][j] == 0 && find(board, word, i + 1, j, cur + 1, used)) {
        return true;
      }
      if(j - 1 >= 0 && used[i][j - 1] == 0 && find(board, word, i, j - 1, cur + 1, used)) {
        return true;
      }

      used[i][j] = 0;
      return false;
    }

  }

}
