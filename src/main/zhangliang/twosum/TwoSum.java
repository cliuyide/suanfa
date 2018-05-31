package main.zhangliang.twosum;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/description/
 * 
 */
public class TwoSum {
    /**
     * 20 / 20 个通过测试用例, 执行用时：8 ms, 已经战胜 79.33 % 的 java 提交记录
     * 
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length < 2) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int m = target - nums[i];
            if (map.get(m) != null) {
                result[0] = map.get(m);
                result[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length < 2) {
            return result;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            int j = nums.length - 1;
            while (j > i) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
                j--;
            }
        }
        return result;
    }
}