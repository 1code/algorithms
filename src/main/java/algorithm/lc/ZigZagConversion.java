package algorithm.lc;

import java.util.Arrays;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * And then read line by line: "PAHNAPLSIIGYIR" Write the code that will take a
 * string and make this conversion given a number of rows:
 * 
 * string convert(string text, int nRows); convert("PAYPALISHIRING", 3) should
 * return "PAHNAPLSIIGYIR".
 * 
 */
// O(nRows * n) space, O(nRows * n) time, where n is the length of string
// size of buffer = nRows * (numGroup * groupWidth)
//                = nRows * (n / groupSize + 1) * (nRows - 1)
//                = nRows * (n / (2 * nRows - 2) + 1) * (nRows - 1)
//                = nRows^2 * n / (2 * nRows - 2) + nRows^2 - (n * nRows) / (2 * nRows - 2) - nRows
public class ZigZagConversion {

  // create a buffer and insert the characters into proper location,
  // then scan row by row to concatenate them
  public class Solution {
    public String convert(String s, int nRows) {
          // Start typing your Java solution below
          // DO NOT write main() function
      if (nRows < 2) {
        return s;
      }
      int groupSize = 2 * nRows - 2;
      int numGroup = s.length() / groupSize + 1;
      int groupWidth = nRows - 1;
      
      char[][] buffer = new char[nRows][numGroup * groupWidth];
      for (char[] row : buffer) {
        Arrays.fill(row, ' ');
      }
      for (int i = 0; i < s.length(); ++i) {
        int groupIdx = i / groupSize;
        int inGroupIdx = i % groupSize;
        if (inGroupIdx < nRows) {
          buffer[inGroupIdx][groupIdx * groupWidth] = s.charAt(i);
        }
        else {
          int offset = inGroupIdx - nRows + 1;
          buffer[nRows - 1 - offset][groupIdx * groupWidth + offset] = s.charAt(i);
        }
      }
      
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < buffer.length; ++i) {
        for (int j = 0; j < buffer[i].length; ++j) {
          if (buffer[i][j] != ' ') {
            sb.append(buffer[i][j]);
          }
        }
      }
      return sb.toString();
    }
  }

}
