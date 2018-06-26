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
	 * TODO 未完待续
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
		int[] arr = new int[10000];
		Arrays.sort(nums);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			arr[nums[i]]++;
		}
		if (sum % k > 0) {
			return false;
		}
		int target = sum / k;
		if (nums[nums.length - 1] > target) {
			return false;
		}
		int leftnum = nums.length;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (arr[nums[i]] > 0) {
				sum = nums[i];
				arr[nums[i]]--;
				leftnum--;
				int j = nums.length - 1;
				while (sum < target && j >= 0) {
					if (arr[nums[j]] > 0) {
						sum += nums[j];
						if (sum <= target) {
							arr[nums[j]]--;
							leftnum--;
						} else {
							sum -= nums[j];
						}
					}
					j--;
				}
				if (sum != target) {
					return false;
				}
			}
		}

		return leftnum == 0;
	}

	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		System.out.println(new EqualSumSubsets().canPartitionKSubsets(
				new int[] { 3522, 181, 521, 515, 304, 123, 2512, 312, 922, 407, 146, 1932, 4037, 2646, 3871, 269 }, 5));
		System.out.println(System.currentTimeMillis());
	}
}
