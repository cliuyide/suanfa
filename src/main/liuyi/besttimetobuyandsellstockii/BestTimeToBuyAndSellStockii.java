package main.liuyi.besttimetobuyandsellstockii;
/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 * @author liuyi
 *
 */
public class BestTimeToBuyAndSellStockii {
	public static void main(String[] args) {
		System.out.println(new BestTimeToBuyAndSellStockii().maxProfit(new int[]{7,1,5,3,6,4}));
	}
	public int maxProfit(int[] prices) {
        int result =0;
        if(prices.length==0){
        	return result;
        }
        int income=prices[0];
        for(int i=1;i<prices.length;i++){
        	if(prices[i]>income){
    			result+=prices[i]-income;
    			income=prices[i];
    		}else{
    			income=prices[i];
    		}
        }
        return result;
    }
}
