/**
https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/description/
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var averageOfLevels = function(root) {
    function addNode(n, level, arr){
        if(n == null) return ;
        var levelNode = arr[level];
        if(!levelNode){
            arr[level] = {
                val : n.val,
                count : 1
            }
        } else {
            levelNode.val += n.val;
            levelNode.count ++;
        }
        addNode(n.left, level+1, arr);
        addNode(n.right, level+1, arr);
    }
    var arr = [];
    addNode(root, 0, arr);
    for(var i in arr){
        arr[i] = arr[i].val/arr[i].count;
    }
    return arr;
};

