package algorithm.dp;

/**
 * The longest common substring problem.
 *
 */
public class LCS {
  
  /**
   * Return the length of longest common substring.
   * @param first
   * @param second
   * @return
   */
  public static int lcsLen(String first, String second) {
    if (first.length() == 0 || second.length() == 0) {
      return 0;
    }
    
    int[][] len = new int[first.length() + 1][second.length() + 1];
    for (int c = 0; c < len.length; ++c) {
      len[0][c] = 0;
    }
    for (int r = 0; r < len[0].length; ++r) {
      len[r][0] = 0;
    }
    
    for (int i = 1; i < len.length; ++i) {
      char cFirst = first.charAt(i - 1);
      for (int j = 1; j < len[i].length; ++j) {
        char cSecond = second.charAt(j - 1);
        if (cFirst == cSecond) {
          len[i][j] = len[i - 1][j - 1] + 1;
        }
        else {
          len[i][j] = Math.max(len[i - 1][j], len[i][j - 1]);
        }
      }
    }
    
    return len[first.length()][second.length()];
  }
  
  public static String lcs(String first, String second) {
    if (first.length() == 0 || second.length() == 0) {
      return "";
    }
    
    int[][] len = new int[first.length() + 1][second.length() + 1];
    for (int c = 0; c < len[0].length; ++c) {
      len[0][c] = 0;
    }
    for (int r = 0; r < len.length; ++r) {
      len[r][0] = 0;
    }
    
    for (int i = 1; i < len.length; ++i) {
      char cFirst = first.charAt(i - 1);
      for (int j = 1; j < len[i].length; ++j) {
        char cSecond = second.charAt(j - 1);
        if (cFirst == cSecond) {
          len[i][j] = len[i - 1][j - 1] + 1;
        }
        else {
          len[i][j] = Math.max(len[i - 1][j], len[i][j - 1]);
        }
      }
    }
    
    // back track
    StringBuilder sb = new StringBuilder();
    int i = first.length(); 
    int j = second.length();
    
    while (!(i == 0 || j == 0)) {
      char cFirst = first.charAt(i - 1);
      char cSecond = second.charAt(j - 1);
      if (cFirst == cSecond) {
        sb.append(cFirst);
        --i;
        --j;
      }
      else {
        if (len[i - 1][j] > len[i][j - 1]) {
          --i;
        }
        else {
          --j;
        }
      }
    }
    
    return sb.reverse().toString();
  }
  
}
