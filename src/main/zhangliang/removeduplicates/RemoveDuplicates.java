package main.zhangliang.removeduplicates;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/description/F
 * 
 * @author zhangliang
 *
 */
public class RemoveDuplicates {
	/**
	 * 
	 * 161 / 161 个通过测试用例,执行用时：17 ms
	 * 
	 * @param nums
	 * @return
	 */
	public int removeDuplicates(int[] nums) {
		int index = 0;
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[index])
				nums[++index] = nums[i];
		}
		return index + 1;
	}
}