/**
 * https://leetcode.com/submissions/detail/157561113/
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isIsomorphic = function(s, t) {
    if(s.length != t.length) return false;
    var smap = {};
    var tmap = {};
    for(var i=0; i<s.length; i++){
        var sletter = s[i];
        var tletter = t[i];
        if(!smap[sletter]){
            smap[sletter] = tletter;
        } else if(smap[sletter] != tletter){
            return false;   
        }
        if(!tmap[tletter]){
            tmap[tletter] = sletter;
        } else if(tmap[tletter] != sletter){
            return false;   
        }
    }
    return true;
};
