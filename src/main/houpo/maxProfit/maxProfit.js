/**
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/description/
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    var maxCha = 0;
    for(var i=0;i<prices.length;i++){
        for(var j=i+1;j<prices.length;j++){
            var cha = prices[j] - prices[i];
            if(cha > maxCha){
                maxCha = cha;
            }
        }
    }
    return maxCha;
};

console.log(maxProfit([7,1,5,3,6,4]));
