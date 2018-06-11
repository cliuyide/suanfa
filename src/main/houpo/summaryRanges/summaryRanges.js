/**
 * @param {number[]} nums
 * @return {string[]}
 */
var summaryRanges = function(nums) {
    if (!nums.length) {
        return [];
    }
    var tmp = {
        start: nums[0],
        next: nums[0]
    };
    var result = [];
    for (var i = 1; i < nums.length; i++) {
        if (nums[i] != tmp.next + 1) {
            if (tmp.start == tmp.next) {
                result.push(tmp.start + "");
            } else {
                result.push(tmp.start + "->" + tmp.next);
            }
            tmp.start = nums[i];
        }
        tmp.next = nums[i];
    }
    if (tmp.start == tmp.next) {
        result.push(tmp.start + "");
    } else {
        result.push(tmp.start + "->" + tmp.next);
    }
    return result;
};
