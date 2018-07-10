package main.zhangliang.besttimetobuy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 */
public class SellStockIII {

    /**
     * 利用了买股票的第一个算法，将prices拆成两个数组 200 / 200 test cases passed. Runtime: 800 ms
     * 
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int max = maxProfit3(prices);
        int rightSize = 2;
        int profit = 0;
        while (rightSize <= prices.length - 2) {
            profit = maxProfit3(Arrays.copyOfRange(prices, 0, prices.length - rightSize)) + maxProfit3(Arrays
                    .copyOfRange(prices, prices.length - rightSize, prices.length));
            if (profit > max) {
                max = profit;
            }
            rightSize++;
        }
        return max;
    }

    private static int maxProfit3(int[] prices) {
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