
/**
* https://leetcode.com/problems/subdomain-visit-count/description/
*/
var subdomainVisits = function(cpdomains) {
    var map = {};
    for(var j=0;j<cpdomains.length;j++){
        var arr = cpdomains[j].split(' ');
        var count = arr[0] * 1;
        for(var i=0;i<arr[1].length;i++){
            if(i==0){
                map[arr[1]] = (map[arr[1]]?map[arr[1]] + count:count);
            } else if(arr[1][i] == '.'){
                var domain = arr[1].substr(i + 1);
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
