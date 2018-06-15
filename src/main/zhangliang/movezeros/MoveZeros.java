package main.zhangliang.movezeros;

/**
 * https://leetcode.com/problems/move-zeroes/description/
 */
public class MoveZeros {

    /**
     * 21 / 21 test cases passed, Runtime: 3 ms
     */
    public void moveZeroes(int[] nums) {
        if (nums != null) {
            int displacement = 0;
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
}