/**
https://leetcode-cn.com/problems/maximize-distance-to-closest-person/description/
 * @param {number[]} seats
 * @return {number}
 */
var maxDistToClosest = function(seats) {
    var max = 1;
    var startPos = 0;
    var endPos = 0;
    for(var i=0;i<seats.length;i++){
        if(seats[i] == 0 && i !=seats.length-1){
            continue;
        } 
        endPos = i;
        if(i ==seats.length-1 && seats[i]==0){
            endPos ++;
        }
        var tmpMax = 0;
        if(startPos == 0 || endPos==seats.length){
            tmpMax = endPos - startPos ;
        } else {
            tmpMax = Math.floor((endPos - startPos )/2.0 + 0.5)
        }
        if(tmpMax>max)
            max = tmpMax;
        startPos = i + 1;
    }
    return max;
    
};
