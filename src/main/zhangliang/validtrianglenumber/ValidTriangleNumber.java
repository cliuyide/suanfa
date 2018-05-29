package main.zhangliang.validtrianglenumber;

import java.util.Arrays;

/**
 * 611. 有效三角形的个数https://leetcode-cn.com/problems/valid-triangle-number/description/
 *
 */
public class ValidTriangleNumber {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    /**
     * 220 / 220 个通过测试用例, 执行用时：77 ms, 已经战胜 73.33 % 的 java 提交记录
     * 
     * @param nums
     * @return
     */
    public int triangleNumber(int[] nums) {
        int result = 0;
        if (nums == null || nums.length < 3) {
            return result;
        }
        // 排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] <= nums[k]) {
                        break;
                    }
                    result++;
                }
            }
        }
        return result;
    }
}
