package main.zhangliang.movezeros;

/**
 * https://leetcode.com/problems/move-zeroes/description/
 */
public class MoveZeros {

    /**
     * 21 / 21 test cases passed, Runtime: 3 ms, 计算非0数的位移
     */
    public void moveZeroes(int[] nums) {
        if (nums != null) {
            int displacement = 0;// 位移
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    displacement++;
                } else if (displacement > 0) {
                    nums[i - displacement] = nums[i];
                    nums[i] = 0;
                }
            }
        }
    }

    /**
     * 参考他人，实际就把前pos个位置插入非0，剩余位置插入0；
     */
    public void moveZeroes2(int[] nums) {
        if (nums != null) {
            int pos = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[pos] = nums[i];
                    pos++;
                }
            }
            for (int j = pos; j < nums.length; j++) {
                nums[j] = 0;
            }
        }
    }
}