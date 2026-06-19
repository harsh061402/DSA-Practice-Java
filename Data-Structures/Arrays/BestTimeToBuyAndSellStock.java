/**
 * Problem: Best Time to Buy and Sell Stock
 * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * * Time Complexity: O(n) - Single pass through the array.
 * Space Complexity: O(1) - Only using a few variables for tracking min price and max profit.
 */

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            // Update minPrice if a lower buying price is found
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            // Calculate current profit and update maxProfit if it's higher
            else {
                int currentProfit = prices[i] - minPrice;
                maxProfit = Math.max(maxProfit, currentProfit);
            }
        }

        return maxProfit;
    }
}