/**
 * Your runtime beats 63.91 % of javascript submissions.
 * https://leetcode.com/problems/count-primes/description/
 * @param {number} n
 * @return {number}
 */
var countPrimes = function(n) {
    var arr = [];
    var sum = 0 ;
    for(var i=2;i<n;i++){
        if(isPrime(arr, i)){
            sum ++;
        }
    }
    return sum;
};
var isPrime = function(arr, i){
    if(i == 2){
        arr.push(i);
        return true;
    }
    var half = Math.sqrt(i);
    for(var j=0;j<arr.length;j++){
        if(i%arr[j] == 0){
            return false;
        }
        if(arr[j]>=half){
            break;
        }
    }
    arr.push(i);
    return true;
}
