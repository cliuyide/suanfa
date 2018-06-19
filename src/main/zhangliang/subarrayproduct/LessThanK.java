package main.zhangliang.subarrayproduct;

import java.util.HashMap;
import java.util.Map;

public class LessThanK {

	public int numSubarrayProductLessThanK(int[] nums, int k) {
		if (nums == null || k == 0) {
			return 0;
		}
		int count = 0;
		long product = 1;
		Integer lastIndex = null;// 从上一个起点开始的最长符合要求的串
		Map<Integer, Integer> map = new HashMap<>();
		for (int startIndex = 0; startIndex < nums.length; startIndex++) {
			// 上一个起点
			lastIndex = map.get(startIndex - 1);
			// 小于0，起点大于k
			if (lastIndex == null || lastIndex < 0) {
				product = 1;
				for (int sublength = 1; sublength <= nums.length - startIndex; sublength++) {
					product = product * nums[startIndex + sublength - 1];
					if (product < k) {
						count++;
						if (sublength == nums.length - startIndex) {
							map.put(startIndex, nums.length - 1);
						}
					} else {
						map.put(startIndex, startIndex + sublength - 2);
						product = product / nums[startIndex + sublength - 1];
						break;
					}
				}
				if (map.get(startIndex).equals(nums.length - 1)) {
					count += subCount(startIndex + 1, nums.length - 1);
					break;
				}

			}
			// 可以省略一些操作
			else {
				count += subCount2(startIndex, lastIndex);
				product = product / nums[startIndex - 1];
				map.put(startIndex, lastIndex);
				for (int sublength = lastIndex - startIndex + 2; sublength <= nums.length - startIndex; sublength++) {
					product = product * nums[startIndex + sublength - 1];
					if (product < k) {
						count++;
					} else {
						map.put(startIndex, startIndex + sublength - 2);
						product = product / nums[startIndex + sublength - 1];
						break;
					}
					if (sublength == nums.length - startIndex) {
						map.put(startIndex, startIndex + sublength - 1);
					}
				}
				if (map.get(startIndex).equals(nums.length - 1)) {
					count += subCount(startIndex + 1, nums.length - 1);
					break;
				}
			}

		}
		return count;
	}

	public static int subCount(int start, int end) {
		if (start < 0 || end < 0 || end < start) {
			return 0;
		}
		int result = 0;
		for (int i = 1; i <= end - start + 1; i++) {
			result += i;
		}
		return result;
	}

	public static int subCount2(int start, int end) {
		if (start < 0 || end < 0 || end < start) {
			return 0;
		}
		return end - start + 1;
	}

	public static void main(String[] args) {
		System.out
				.println(new LessThanK().numSubarrayProductLessThanK(new int[] { 1,1,1 }, 289));
		// System.out.println(new LessThanK().numSubarrayProductLessThanK(new
		// int[] { 1,1,1 }, 2));
		// System.out.println(new LessThanK().numSubarrayProductLessThanK(new
		// int[] { 10, 5, 2, 6 }, 100));
		// System.out.println(new LessThanK().numSubarrayProductLessThanK(new
		// int[] { 10,9,10,4,3,8,3,3,6,2,10,10,9,3}, 19));
	}
}