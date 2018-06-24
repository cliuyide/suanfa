/**
https://leetcode-cn.com/problems/jump-game/description/
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function(nums) {
    
    for(var i=0;i<nums.length;i++){
        if(nums[i] == 0 && i!=nums.length-1){
            if(!can(nums, i)){
                return false;
            }
        }
    }
    return true;
    
};

function can(nums, n){
    for(var i=n-1;i>=0;i--){
        if(nums[i]>(n-i)){
            return true;
        }
    }
    return false;
}
