package main.zhangliang.jumpgame;

/**
 * https://leetcode.com/problems/jump-game/description/
 * 
 * @author zhangliang
 *
 */
public class JumpGame {
	/**
	 * 75 / 75 test cases passed， Runtime: 9 ms，66.62%
	 */
	public boolean canJump(int[] nums) {
		boolean result = true;
		if (nums == null || nums.length == 0) {
			return result;
		}
		int maxIndex = 0;
		for (int i = 0; i <= nums.length - 1; i++) {
			if (maxIndex < i) {
				result = false;
				break;
			}
			if (i + nums[i] > maxIndex) {
				maxIndex = i + nums[i];
			}
		}
		return result;
	}
}
