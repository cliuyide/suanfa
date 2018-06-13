/**
 * @param {string} s
 * @param {string} t
 * @return {character}
 */
var findTheDifference = function(s, t) {
      var chaArr = [];
    for (var i = 0; i < s.length; i++) {
        chaArr[s[i]] = !chaArr[s[i]]?1: chaArr[s[i]]+ 1;
    }
    for (var i = 0; i < t.length; i++) {
        if (chaArr[t[i]]!=0 && !chaArr[t[i]]) {
            return t[i];
        }
        chaArr[t[i]] --;
        if(chaArr[t[i]]<0){
            return t[i];
        }
    }
};
