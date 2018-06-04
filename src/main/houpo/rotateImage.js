/**
 * https://leetcode.com/problems/rotate-image/description/
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var rotate = function(matrix) {
    var newArr = [];
    var n = matrix.length;
    for (var i = 0; i < matrix.length; i++) {
        newArr[i] = [];
        for (var j = 0; j < matrix[i].length; j++) {
            var nowPos = Math.min(i, j, Math.abs(n - 1 - i), Math.abs(n - 1 - j));
            var offset = n - 2 * nowPos;
            var point = getRotatePoint(i - nowPos, j - nowPos, offset);
            newArr[i][j] = matrix[point[0] + nowPos][point[1] + nowPos];
        }
    }
    console.log(newArr);
};

var getRotatePoint = function(i, j, n) {
    n = n - 1;
    if (n == 0)
        return [i, j];
    if (j == 0) {
        return [n, i];
    }
    if (i == n) {
        return [(n - j), n];
    }
    if (j == n) {
        return [0, i];
    }
    if (i == 0) {
        return [n - j, 0];
    }
}

rotate([[1, 2, 3, 4, 5], [4, 5, 6, 7, 8], [7, 8, 9, 10, 11], [7, 8, 9, 10, 11], [7, 8, 9, 10, 11]])
