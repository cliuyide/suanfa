package main.liuyi.binarytreeinordertraversal;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/
 * 递归做法
 * 
 * @author liuyi
 *
 */
public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		handle(root, result);
		return result;
	}

	public void handle(TreeNode node, List<Integer> result) {
		if (node.left != null) {
			handle(node.left, result);
		}
		result.add(node.val);
		if (node.right != null) {
			handle(node.right, result);
		}
	}
}
