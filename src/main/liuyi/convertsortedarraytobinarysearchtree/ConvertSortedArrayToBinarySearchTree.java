package main.liuyi.convertsortedarraytobinarysearchtree;

public class ConvertSortedArrayToBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0) {
			return null;
		}
		if (nums.length == 1) {
			return new TreeNode(nums[0]);
		}
		int halfLength = nums.length / 2;
		while(halfLength>0){
			
		}
		TreeNode result = new TreeNode(nums[halfLength]);
		return result;
	}

	private void handler(int start, int end, boolean isLeft, int[] nums, TreeNode result) {
		if (end - start == 0) {

		}
		int halfNum = (end - start)/2;
		if (isLeft) {
			result.left = new TreeNode(nums[halfNum + start]);
			handler(start, halfNum, true, nums, result.left);
			handler(halfNum, end, false, nums, result.left);
		} else {
			result.right = new TreeNode(nums[halfNum + start]);
			handler(start, halfNum, true, nums, result.right);
			handler(halfNum, end, false, nums, result.right);
		}

	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
