package main.zhangliang.maxconsecutiveones;

/**
 * 最大连续1的个数https://leetcode-cn.com/problems/max-consecutive-ones/description/
 */
public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    /**
     * 41 / 41 个通过测试用例, 执行用时：8 ms, 已经战胜 81.99 % 的 java 提交记录
     * 
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        if (nums == null || nums.length == 0) {
            return max;
        }
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                current++;
            } else {
                if (current > max) {
                    max = current;
                }
                current = 0;
            }
        }
        if (current > max) {
            max = current;
        }
        return max;
    }

    public int findMaxConsecutiveOnes2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int max = 0, current = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 1) {
                current++;
            } else {
                if (current > max) {
                    max = current;
                }
                if (i + 1 < nums.length) {
                    current = nums[++i];
                } else {
                    current = 0;
                }
            }
        }
        if (current > max) {
            max = current;
        }
        return max;
    }
}
