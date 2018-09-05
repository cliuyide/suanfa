package main.liuyi.convertsortedarraytobinarysearchtree;

/**
 * 108 TODO 没做出来
 * 
 * @author liuyi
 *
 */
public class ConvertSortedArrayToBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0)
			return null;
		return getTree(nums, 0, nums.length - 1);
	}

	public TreeNode getTree(int[] nums, int l, int r) {
		if (l <= r) {
			int mid = (l + r) / 2;
			TreeNode node = new TreeNode(nums[mid]);
			node.left = getTree(nums, l, mid - 1);
			node.right = getTree(nums, mid + 1, r);
			return node;
		} else {
			return null;
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
