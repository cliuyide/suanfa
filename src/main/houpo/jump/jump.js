/**
https://leetcode-cn.com/problems/jump-game-ii/description/
 * @param {number[]} nums
 * @return {number}
 */
var jump = function(nums) {
    if(nums.length<=1) return 0;
    var re = {count :1};
    getMax(nums, 0, 0, re);
    return re.count;
    
};

function getMax(nums, start, end, re){
    var max = end;
    for(var i=start;i<=end;i++){
            if(nums[i] + i + 1>=nums.length){
                return re;
            }
            if(nums[i] + i>max){
                max = nums[i] + i;
            }
    }
    re.count ++;
    return getMax(nums, end+1, max, re);
}
