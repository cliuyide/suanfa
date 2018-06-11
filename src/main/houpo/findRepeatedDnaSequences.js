/**
 * https://leetcode.com/problems/repeated-dna-sequences/description
 * @param {string} s
 * @return {string[]}
 */
var findRepeatedDnaSequences = function(s) {
    if(s.length<11){
        return [];
    }
    var map = {};
    var re = [];
    for(var i=0;i<s.length-9;i++){
        var subStr = s.substr(i, 10);
        if(map[subStr]){
            map[subStr] = map[subStr] +1;
            if(map[subStr] == 2){
                re.push(subStr);
            }
        } else {
            map[subStr] = 1;
        }
    }
    return re;
};
findRepeatedDnaSequences("AAAAAAAAAAA")
