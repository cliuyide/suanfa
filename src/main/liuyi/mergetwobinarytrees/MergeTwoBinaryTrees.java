package main.liuyi.mergetwobinarytrees;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

/**
 * https://leetcode-cn.com/problems/merge-two-binary-trees/description/
 */
public class MergeTwoBinaryTrees {
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) {
			return null;
		}
		TreeNode result = new TreeNode(0);
		handle(t1, t2, result);
		return result;
	}

	private void handle(TreeNode t1, TreeNode t2, TreeNode result) {
		if (t1 != null || t2 != null) {
			int t1Val = t1 == null ? 0 : t1.val;
			int t2Val = t2 == null ? 0 : t2.val;
			result.val = t1Val + t2Val;
		}

		TreeNode t1Left = t1 == null ? null : t1.left;
		TreeNode t2Left = t2 == null ? null : t2.left;
		if (t1Left != null || t2Left != null) {
			result.left = new TreeNode(0);
			handle(t1Left, t2Left, result.left);
		}
		TreeNode t1Right = t1 == null ? null : t1.right;
		TreeNode t2Right = t2 == null ? null : t2.right;
		if (t1Right != null || t2Right != null) {
			result.right = new TreeNode(0);
			handle(t1Right, t2Right, result.right);
		}
	}

}
