package main.zhangliang.besttimetobuy;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 */
public class SellStock {
    /**
     * 200 / 200 test cases passed.Runtime: 308 ms
     * 
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int profit = 0;
        for (int sell = prices.length - 1; sell > 0; sell--) {
            for (int buy = 0; buy < sell; buy++) {
                if (prices[sell] - prices[buy] > profit) {
                    profit = prices[sell] - prices[buy];
                }
            }
        }
        return profit;
    }

    /**
     * 200 / 200 test cases passed.Runtime: 4 ms
     * 
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int profit = 0;
        for (int sell = prices.length - 1; sell > 0; sell--) {
            if (prices[sell] > prices[sell - 1]) {
                for (int buy = 0; buy < sell; buy++) {
                    if (prices[sell] - prices[buy] > profit) {
                        profit = prices[sell] - prices[buy];
                    }
                }
            }
        }
        return profit;
    }

    /**
     * 200 / 200 test cases passed. Runtime: 1 ms
     * 
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int profit = 0;
        int minBuy = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[minBuy]) {
                minBuy = i;
            } else if (prices[i] - prices[minBuy] > profit) {
                profit = prices[i] - prices[minBuy];
            }
        }
        return profit;
    }
}
