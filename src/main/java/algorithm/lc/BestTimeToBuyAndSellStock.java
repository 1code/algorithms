package algorithm.lc;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * If you were only permitted to complete at most one transaction (ie, buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 * 
 */
// O(1) space, O(n) time
public class BestTimeToBuyAndSellStock {

  // keep track the min price so far, and record the max profit
  public class Solution {
    public int maxProfit(int[] prices) {
      // Start typing your Java solution below
      // DO NOT write main() function
      int minPrice = Integer.MAX_VALUE;
      int maxProfit = 0;
      for (int i = 0; i < prices.length; ++i) {
        minPrice = Math.min(minPrice, prices[i]);
        maxProfit = Math.max(maxProfit, prices[i] - minPrice);
      }
      return maxProfit;
    }
  }

}
