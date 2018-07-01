/**
https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/description/
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    if (!nums.length)
        return 0;
    var prev = nums[0];
    var nowIndex = 1;
    for (var i = 1; i < nums.length; i++) {
        if (nums[i] == prev) {
            continue;
        }
        prev = nums[i]
        nums[nowIndex] = prev;
        nowIndex++;
    }
    return nowIndex;
};
