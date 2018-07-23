package main.liuyi.besttimetobuyandsellstockiii;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.alibaba.fastjson.JSON;
/**
 * TODO
 * @author liuyi
 *
 */
public class BesTimeToBuyAndSellStockIii2 {
	public static void main(String[] args) {
		System.out.println(new BesTimeToBuyAndSellStockIii2().maxProfit(new int[] { 1, 2, 4, 2, 5, 7, 2, 4, 9, 0 }));
	}

	public int maxProfit(int[] prices) {
		int result = 0;
		if (prices.length <= 1) {
			return result;
		}
		int[] params = new int[prices.length];
		int maxNum = 2;
		int minNum = 1;
		for (int i = 1; i < prices.length; i++) {
			int nowNum = prices[i];
			int nextNum = 0;
			// 最后一位做下处理,补个0
			if (i != prices.length - 1) {
				nextNum = prices[i + 1];
			}
			int preNum = prices[i - 1];
			// 如果当前数大于前一个数并大于或等于下一个数,算他为一个峰值
			if ((nowNum > preNum && nowNum >= nextNum) || (nowNum >= preNum && nowNum > nextNum)) {
				params[i] = maxNum;
				// 处理第一位
				if (params[0] == 0) {
					params[0] = minNum;
				}
			} else if ((nowNum < preNum && nowNum <= nextNum) || (nowNum <= preNum && nowNum < nextNum)) {
				params[i] = minNum;
				// 处理第一位
				if (params[0] == 0) {
					params[0] = maxNum;
				}
			}
		}
		List<Integer> resultList = new ArrayList<>();
		Integer a = null;
		for (int i = 0; i < params.length; i++) {
			if (params[i] == 0) {
				continue;
			} else if (params[i] == 1) {
				if (a == null) {
					a = i;
				}
			} else if (params[i] == 2) {
				if (a == null) {
					continue;
				} else {
					for(int j=i;j<params.length;j++){
						int max=prices[j]-prices[a];
					}
				}
			}
		}
		resultList.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		for (int i = 0; i < resultList.size(); i++) {
			if (i >= 2)
				break;
			result += resultList.get(i);
		}
		return result;
	}
}
