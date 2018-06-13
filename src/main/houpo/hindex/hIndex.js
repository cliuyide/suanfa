/**
*https://leetcode.com/problems/h-index/description/
*/
var hIndex = function(citations) {
    var arr = citations.sort(sequence);
    for (var i = arr.length; i >= 0; i--) {
        var nowRe = i + 1;
        if (arr[arr.length - nowRe] >= nowRe) {
            return nowRe;
        }
    }
    return 0;
};
function sequence(a, b) {
    if (a > b) {
        return 1;
    } else if (a < b) {
        return -1
    } else {
        return 0;
    }
}
