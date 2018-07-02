package main.liuyi.besttimetobuyandsellstock;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/description/
 * 
 * @author liuyi
 *
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStock().maxProfit(new int[] { 7, 6, 4, 3, 1 }));
    }
    public int maxProfit(int[] prices) {
        int result = 0;
        if (prices.length == 0) {
            result = 0;
        }
        int min = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[min]) {
                min = i;
            } else {
                if (prices[i] - prices[min] > result) {
                    result = prices[i] - prices[min];
                }
            }
        }
        return result;
    }
}
