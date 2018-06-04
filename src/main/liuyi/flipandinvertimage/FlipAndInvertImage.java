package main.liuyi.flipandinvertimage;

/**
 * 翻转图像 https://leetcode-cn.com/problems/flipping-an-image/description/
 */
public class FlipAndInvertImage {
//    public static void main(String[] args) {
//        System.out.println(JSON.toJSONString(new FlipAndInvertImage().flipAndInvertImage(new int[][] { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 0, 0 } })));
//    }
    public int[][] flipAndInvertImage(int[][] A) {
        if (A.length == 0) {
            return new int[0][0];
        }
        int[][] result = new int[A.length][];
        for (int i = 0; i < A.length; i++) {
            if (A[i].length == 0) {
                continue;
            }
            int[] params = new int[A[i].length];
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == 0) {
                    params[A[i].length - j - 1] = 1;
                } else {
                    params[A[i].length - j - 1] = 0;
                }
            }
            result[i] = params;
        }
        return result;
    }
}
