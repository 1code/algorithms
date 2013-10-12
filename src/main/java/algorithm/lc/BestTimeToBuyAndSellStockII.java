package algorithm.lc;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (ie, buy one and sell one share of the stock
 * multiple times). However, you may not engage in multiple transactions at the
 * same time (ie, you must sell the stock before you buy again).
 * 
 */
public class BestTimeToBuyAndSellStockII {

  // O(1) space, O(n) time
  // accumulate
  public class Solution {
    public int maxProfit(int[] prices) {
      // Start typing your Java solution below
      // DO NOT write main() function
      int maxProfit = 0;
      for (int i = 0; i < prices.length - 1; ++i) {
        maxProfit += Math.max(0, prices[i + 1] - prices[i]);
      }
      return maxProfit;
    }
  }

}
