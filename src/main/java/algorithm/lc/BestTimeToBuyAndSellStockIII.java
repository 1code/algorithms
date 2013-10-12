package algorithm.lc;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i. 
 * Design an algorithm to find the maximum profit. You may complete at
 * most two transactions. Note: You may not engage in multiple transactions at
 * the same time (ie, you must sell the stock before you buy again).
 * 
 */
public class BestTimeToBuyAndSellStockIII {
  
  // O(n) space, O(n) time
  public class Solution {
    
    // two scans, first scan keep track the max profit that end at each day.
    // second scan find the max profit that starts at each day to the last day
    public int maxProfit(int[] prices) {
      // Start typing your Java solution below
      // DO NOT write main() function
      int maxProfit = 0;
      int minPrice = Integer.MAX_VALUE;
      int[] firstBuy = new int[prices.length];
      for (int i = 0; i < prices.length; ++i) {
        maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        minPrice = Math.min(minPrice, prices[i]);
        firstBuy[i] = maxProfit;
      }

      int maxPrice = Integer.MIN_VALUE;
      maxProfit = 0;
      for (int i = prices.length - 1; i >= 0; --i) {
        maxPrice = Math.max(maxPrice, prices[i]);
        maxProfit = Math.max(maxProfit, firstBuy[i] + maxPrice - prices[i]);
      }

      return maxProfit;
    }
  }

}
