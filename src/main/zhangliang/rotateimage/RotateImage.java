package main.zhangliang.rotateimage;

public class RotateImage {

	/**
	 * 21 / 21 个通过测试用例 , 执行用时：2 ms, 已经战胜 96.99 % 的 java 提交记录
	 * 
	 * @param matrix
	 */
	public void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 1) {
			return;
		}
		int loop = 0;//第几圈，从0开始
		for (int x = matrix.length - 1; x >= matrix.length / 2; x--) {
			int sublength = matrix.length - 2 * loop;//边长
			if (sublength > 1) {
				for (int y = x; y > loop; y--) {
					int temp = matrix[x][y];
					matrix[x][y] = matrix[x - y + loop][x];
					matrix[x - y + loop][x] = matrix[loop][x - y + loop];
					matrix[loop][x - y + loop] = matrix[y][loop];
					matrix[y][loop] = temp;
				}
			}
			loop++;
		}
	}
}
