package main.zhangliang.partitiontok;

import java.util.Arrays;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/
 * 
 * @author zhangliang
 *
 */
public class EqualSumSubsets {
	/**
	 * 147 / 147 test cases passed.Runtime: 29 ms
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
		Set<Integer> leftIndexs = new TreeSet<>();
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			leftIndexs.add(i);
		}
		if (sum % k > 0) {
			return false;
		}
		int target = sum / k;
		if (nums[nums.length - 1] > target) {
			return false;
		}
		Stack<Integer> stack = new Stack<>();
		Integer tempSum = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (leftIndexs.size() > 0 && leftIndexs.contains(i)) {
				stack.clear();
				tempSum = 0;
				if (!canSumToTarget(nums, leftIndexs, i, target, stack, tempSum)) {
					return false;
				}
			}
		}

		return leftIndexs.size() == 0;
	}

	/**
	 * 给定数组，判断是否存在几个数的和等于target
	 * 
	 * @return
	 */
	private static boolean canSumToTarget(int[] nums, Set<Integer> leftIndexs, int startIndex, int target,
			Stack<Integer> stack, Integer sum) {
		if (leftIndexs.size() == 0)
			return false;
		if (nums == null || nums.length == 0)
			return false;
		if (startIndex >= nums.length)
			return false;
		int min = 0;
		for (Integer integer : leftIndexs) {
			min = integer;
			break;
		}

		if (startIndex < min) {
			if (stack.isEmpty()) {
				return false;
			}
			startIndex = stack.pop();
			sum -= nums[startIndex];
			leftIndexs.add(startIndex);
			startIndex--;
		}

		if (leftIndexs.contains(startIndex)) {
			sum += nums[startIndex];
			stack.push(startIndex);
			leftIndexs.remove(startIndex);
			if (sum.equals(target)) {
				return true;
			} else if (sum > target) {
				sum -= nums[startIndex];
				leftIndexs.add(startIndex);
				return canSumToTarget(nums, leftIndexs, stack.pop() - 1, target, stack, sum);
			} else {
				return canSumToTarget(nums, leftIndexs, startIndex - 1, target, stack, sum);
			}
		} else {
			return canSumToTarget(nums, leftIndexs, startIndex - 1, target, stack, sum);
		}
	}

	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		System.out.println(new EqualSumSubsets().canPartitionKSubsets(
				new int[] { 3522, 181, 521, 515, 304, 123, 2512, 312, 922, 407, 146, 1932, 4037, 2646, 3871, 269 }, 5));
		System.out.println(System.currentTimeMillis());
	}
}
