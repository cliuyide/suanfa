package main.zhangliang.jumpgame;

/**
 * https://leetcode.com/problems/jump-game-ii/description/
 * 
 * @author zhangliang
 */
public class JumpGameII {

	/**
	 * 92 / 92 test cases passed.Runtime: 224 ms
	 * 
	 * @param nums
	 * @return
	 */
	public int jump(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return 0;
		}
		int minStep = 0;
		int left = 0;
		int right = 0;
		int[] arr = null;
		while (right < nums.length - 1) {
			arr = tryJump(left, right, nums);
			if (arr == null) {
				break;
			}
			left = arr[0];
			right = arr[1];
			minStep++;
		}
		if (right >= nums.length - 1) {
			return minStep;
		} else {
			return 0;
		}
	}

	private static int[] tryJump(int start, int end, int[] nums) {
		if (end < start)
			return null;
		int min = 0;
		int max = 0;
		int temp = 0;
		for (int i = start; i <= end; i++) {
			temp = nums[i] + i;
			if (temp > max) {
				max = temp;
			} else if (temp < min) {
				min = temp;
			}
		}
		if (max > end) {
			return new int[] { min, max };
		} else {
			return null;
		}
	}
}
