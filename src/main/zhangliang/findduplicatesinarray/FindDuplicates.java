package main.zhangliang.findduplicatesinarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/description/
 * @author zhangliang
 *
 */
public class FindDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 不是O(n)的时间复杂度，没想到该怎么完美的解决，
	 * 28 / 28 个通过测试用例， 执行用时：41 ms
	 * @param nums
	 * @return
	 */
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> result = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1])
				result.add(nums[i]);
		}
		return result;
	}
}
