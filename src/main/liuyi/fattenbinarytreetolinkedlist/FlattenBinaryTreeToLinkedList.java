package main.liuyi.fattenbinarytreetolinkedlist;

/**
 * https://leetcode-cn.com/submissions/detail/6150836/
 * 
 * @author liuyi
 *
 */
public class FlattenBinaryTreeToLinkedList {
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		t1.left = t2;
		t1.right = t5;
		t2.left = t3;
		t2.right = t4;
		t5.right = t6;
		new FlattenBinaryTreeToLinkedList().flatten(t1);
	}

	public void flatten(TreeNode root) {
		if (root == null)
			return;
		TreeNode right = root.right;
		root.right = null;
		convent(root.left, root);
		convent(right, root);
		root.left = null;
	}

	private void convent(TreeNode root, TreeNode result) {
		if (root == null) {
			return;
		}
		while (result.right != null) {
			result = result.right;
		}
		result.right = new TreeNode(root.val);
		if (root.left != null) {
			convent(root.left, result.right);
		}
		if (root.right != null) {
			convent(root.right, result.right);
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
