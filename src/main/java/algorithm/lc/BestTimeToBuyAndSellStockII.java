package algorithm.lc;

// O(1) space, O(n) time
public class BestTimeToBuyAndSellStockII {
  
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
