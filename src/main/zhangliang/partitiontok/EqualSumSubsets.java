package main.zhangliang.partitiontok;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/
 * 
 * @author zhangliang
 *
 */
public class EqualSumSubsets {
	/**
	 * TODO
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public boolean canPartitionKSubsets(int[] nums, int k) {
		if (nums == null) {
			return false;
		}
		if (k > nums.length) {
			return false;
		} else if (nums.length == 1 && k == 1) {
			return true;
		}
		Arrays.sort(nums);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if (sum % k > 0) {
			return false;
		}
		int target = sum / k;
		if (nums[nums.length - 1] > target) {
			return false;
		}

		return true;
	}
}
