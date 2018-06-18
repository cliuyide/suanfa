/**
https://leetcode.com/problems/subarray-product-less-than-k/
You are here! 
Your runtime beats 95.45 % of javascript submissions.
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var numSubarrayProductLessThanK = function(nums, k) {
    var start = 0;
    var count = 0;
    var sum = 1;
    var last = 0;
    for (var i = 0; i < nums.length; i++) {
        if (i != 0 && nums[i] == 1 && nums[i - 1] == 1) {
            count += last;
            if(last>0){
                last--;
            }
            continue;
        }
        if (nums[i] < k) {
            count++;
        } else {
            continue;
        }
        if (i == nums.length - 1) {
            break;
        }
        start = i;
        sum = nums[i];
        last = 0;
        for (var j = i + 1; j < nums.length; j++) {
            if (nums[j] == 1) {
                last++;
            } else {
                sum = sum * nums[j];
                if (sum < k) {
                    last++;
                } else {
                    break;
                }
            }
        }
        count += last;

    }
    return count;
};
