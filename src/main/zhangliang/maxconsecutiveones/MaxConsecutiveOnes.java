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
                if (nums.length - i == 1 && current > max) {
                    max = current;
                }
            } else {
                if (current > max) {
                    max = current;
                }
                current = 0;
            }
        }
        return max;
    }

}
