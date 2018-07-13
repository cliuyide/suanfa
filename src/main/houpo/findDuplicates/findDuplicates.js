/**
https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/description/
 * @param {number[]} nums
 * @return {number[]}
 */
var findDuplicates = function(nums) {
    var tmp = 0;
    var count = 0;
    for(var i=0;i<nums.length;i++){
        while(nums[i] !=-1 && nums[i] !=0 && nums[i] != i + 1){
            tmp = nums[nums[i] - 1];
            if(tmp == nums[i] ){
                count ++;
                nums[nums[i] - 1] = 0;
                nums[i] = -1;
                break;
            }
            // exchange
            nums[nums[i] - 1] = nums[i];
            nums[i] = tmp;
        }
    }
    
    for(var i=nums.length-1;i>=0;i--){
        if(nums[i] != 0){
            nums.splice(i, 1);
        }else{
            nums[i] = i+1;
        }
    }
    return nums;
};
