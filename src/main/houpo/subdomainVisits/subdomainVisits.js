
/**
* https://leetcode.com/problems/subdomain-visit-count/description/
You are here! 
Your runtime beats 100.00 % of javascript submissions. * @param {string[]} cpdomains
 * @return {string[]}
 */
var subdomainVisits = function(cpdomains) {
    var map = {};
    for(var j=0;j<cpdomains.length;j++){
        var index = cpdomains[j].indexOf(' ');
        var count = cpdomains[j].substring(0, index) * 1;
        var domainStr = cpdomains[j].substr(index + 1);
        for(var i=0;i<domainStr.length;i++){
            if(i==0 || domainStr[i] == '.'){
                var domain = domainStr.substr(i == 0?0:i+ 1);
                map[domain] = (map[domain]?map[domain] + count:count);
            }
        }
    }
    var reArr = [];
    for(var p in map){
        reArr.push(map[p] + ' ' +p);
    }
    return reArr;
};
console.log(subdomainVisits(["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]));
