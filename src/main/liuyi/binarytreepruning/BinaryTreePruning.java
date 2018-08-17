package main.liuyi.binarytreepruning;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

/**
 * 二叉树剪枝https://leetcode-cn.com/submissions/detail/5671928/
 * 
 * @author liuyi
 *
 */
public class BinaryTreePruning {
	public TreeNode pruneTree(TreeNode root) {
		if (root == null) {
			return root;
		}
		handler(root, root, true, true);
		if (root.left == null && root.right == null && root.val == 0) {
			return null;
		}
		return root;
	}

	private void handler(TreeNode root, TreeNode parent, boolean isLeft, boolean isRoot) {
		if (root.left != null) {
			handler(root.left, root, true, false);
		}
		if (root.right != null) {
			handler(root.right, root, false, false);
		}
		if (root.left == null && root.right == null) {
			if (root.val == 0 && isLeft&&!isRoot) {
				parent.left = null;
			}
			if (root.val == 0 && !isLeft && !isRoot) {
				parent.right = null;
			}
		}
	};
}
