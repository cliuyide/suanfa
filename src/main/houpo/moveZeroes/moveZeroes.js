/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 * https://leetcode.com/problems/move-zeroes/description/
 */
var moveZeroes = function(nums) {
    var nowIndex = 0;
    for(var i=0;i<nums.length;i++){
        if(nums[i] != 0){
            nums[nowIndex] = nums[i];
            nowIndex ++;
        }
    }
    for(var j=nowIndex;j<nums.length;j++){
        nums[j] = 0;
    }
};
