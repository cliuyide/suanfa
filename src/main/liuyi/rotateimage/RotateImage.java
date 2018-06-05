package main.liuyi.rotateimage;

import com.alibaba.fastjson.JSON;

/**
 * https://leetcode.com/problems/rotate-image/description/ TODO 还有更好的做法吗
 * 
 * @author liuyi
 *
 */
public class RotateImage {
    public static void main(String[] args) {
        new RotateImage().rotate(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });
    }

    public void rotate(int[][] matrix) {
        int[][] tem = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                tem[i][j] = matrix[matrix.length - j - 1][i];
            }
        }
        System.out.println(JSON.toJSONString(tem));
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = tem[i][j];
            }
        }
        System.out.println(JSON.toJSONString(matrix));
    }
}
