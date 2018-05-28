package main.zhangliang.flippingimage;

public class FlipAndInvertImage {

    public static void main(String[] args) {
        int[] arr = new int[] { 0, 1, 1, 0, 1 };
        int[] arr1 = new int[] { 0, 1, 1, 0, 0 };
        int[] arr2 = new int[] { 0, 1, 1, 0, 0 };
        int[] arr3 = new int[] { 0, 1, 1, 0, 1 };
        int[] arr5 = new int[] { 0, 1, 1, 0, 1 };
        int[][] arr4 = new int[][] { arr, arr1, arr2, arr3, arr5 };
        new FlipAndInvertImage().flipAndInvertImage(arr4);
        System.out.println(arr2);
    }

    /**
     * 返回i^1的值
     * 
     * @param i
     * @return
     */
    private static int xor1(int i) {
        return i ^ 1;
    }

    public int[][] flipAndInvertImage(int[][] A) {
        int length = A.length;
        int loop = length / 2;
        if (length % 2 > 0) {
            loop += 1;
        }
        int end = 0;
        int right = 0;
        int temp = 0;
        for (int i = 0; i < loop; i++) {
            end = length - i - 1;
            if (end > i) {
                for (int j = 0; j < loop; j++) {
                    right = length - j - 1;
                    if (right > j) {
                        temp = xor1(A[i][j]);
                        A[i][j] = xor1(A[i][right]);
                        A[i][right] = temp;
                        temp = xor1(A[end][j]);
                        A[end][j] = xor1(A[end][right]);
                        A[end][right] = temp;
                    } else if (right == j) {
                        A[i][j] = xor1(A[i][j]);
                        A[end][j] = xor1(A[end][j]);
                    }
                }
            } else if (end == i) {
                for (int j = 0; j < loop; j++) {
                    right = length - j - 1;
                    if (right > j) {
                        temp = xor1(A[i][j]);
                        A[i][j] = xor1(A[i][right]);
                        A[i][right] = temp;
                    } else if (right == j) {
                        A[i][j] = xor1(A[i][j]);
                    }
                }
            }
        }
        return A;
    }
}