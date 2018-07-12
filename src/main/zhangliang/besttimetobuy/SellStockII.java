package main.zhangliang.besttimetobuy;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 */
public class SellStockII {
    /**
     * 201 / 201 test cases passed.Runtime: 1 ms
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int maxProfit = 0;
        int profit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - minPrice > profit) {
                profit = prices[i] - minPrice;
            } else {
                minPrice = prices[i];
                if (profit > 0) {
                    maxProfit += profit;
                    profit = 0;
                }
            }
        }
        if (profit > 0) {
            maxProfit += profit;
        }
        return maxProfit;
    }

    /**
     * 201 / 201 test cases passed.Runtime: 1 ms
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
