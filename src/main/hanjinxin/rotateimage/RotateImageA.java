package main.hanjinxin.rotateimage;

// https://leetcode.com/problems/rotate-image/description/
public class RotateImageA { // Runtime: 2 ms  Your runtime beats 100.00 % of java submissions.
    public void rotate(int[][] matrix) {
        int subMatrixLength = matrix.length/2;
        for(int col=0; col<subMatrixLength; col++){ // 列
            int elementNum = matrix.length-1-col*2; // 每列需要旋转的元素个数
            for(int num=0; num<elementNum; num++){
                rotateFourElements(matrix, col+num, col);
            }
        }
    }
    
    public void rotateFourElements(int[][] matrix, int row, int col){ // 旋转四条边上对应的点  
        int rotateDistance = matrix.length-1;
        int nexti = col; 
        int nextj = rotateDistance-row; 
        int prevalue = matrix[row][col];
        int currentvalue = matrix[nexti][nextj];
        // matrix[i][j]旋转90度后对应的点是matrix[j][matrix.length-1-i]
        for(int k=0; k<4; k++){
            currentvalue = matrix[nexti][nextj];
            matrix[nexti][nextj] = prevalue;
            int temp = rotateDistance - nexti;
            nexti = nextj;
            nextj = temp;
            prevalue = currentvalue;
        }
    }
    
    public void print(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                System.out.print(" "+matrix[i][j]);
            }
            System.out.println("");
        }
    }
    
    public static void main(String[] args) {
        RotateImageA a = new RotateImageA();
//        int[][] matrix = new int[4][4];
//        matrix[0][0] = 5;
//        matrix[0][1] = 1;
//        matrix[0][2] = 9;
//        matrix[0][3] = 11;
//        matrix[1][0] = 2;
//        matrix[1][1] = 4;
//        matrix[1][2] = 8;
//        matrix[1][3] = 10;
//        matrix[2][0] = 13;
//        matrix[2][1] = 3;
//        matrix[2][2] = 6;
//        matrix[2][3] = 7;
//        matrix[3][0] = 15;
//        matrix[3][1] = 14;
//        matrix[3][2] = 12;
//        matrix[3][3] = 16;
        int[][] matrix = new int[3][3];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[1][0] = 4;
        matrix[1][1] = 5;
        matrix[1][2] = 6;
        matrix[2][0] = 7;
        matrix[2][1] = 8;
        matrix[2][2] = 9;
//        int[][] matrix = new int[2][2];
//        matrix[0][0] = 1;
//        matrix[0][1] = 2;
//        matrix[1][0] = 3;
//        matrix[1][1] = 4;
        System.out.println("原二维数组");
        a.print(matrix);
        System.out.println("旋转后二维数组");
        a.rotate(matrix);
        a.print(matrix);
    }
}
