package algorithm.lc;

/**
 * There are N children standing in a line. Each child is assigned a rating
 * value.
 * 
 * You are giving candies to these children subjected to the following
 * requirements:
 * 
 * Each child must have at least one candy. Children with a higher rating get
 * more candies than their neighbors. What is the minimum candies you must give?
 * 
 */
public class Candy {
  
  // O(n) space, O(n) time
  // one scan from left to right, get the relative height compare with left element,
  // another scan from right to left, get the relative height compare with right element
  public class Solution {
    public int candy(int[] ratings) {
          // Note: The Solution object is instantiated only once and is reused
      if (ratings.length == 0) {
          return 0;
      }
      int min = ratings.length; 
      int give = 0;
      int[] candies = new int[ratings.length];
      for (int i = 1; i < ratings.length; ++i) {
        if (ratings[i] > ratings[i - 1]) {
          ++give;
        }
        else {
          give = 0;
        }
        candies[i] = give; // relative height compare with left
      }
      
      give = 0;
      for (int i = ratings.length - 2; i >= 0; --i) {
        if (ratings[i] > ratings[i + 1]) {
          ++give;
        }
        else {
          give = 0;
        }
        candies[i] = Math.max(give, candies[i]); // relative height compare with right
        min += candies[i];
      }
      min += candies[ratings.length - 1];
      return min;
    }
  }

}
