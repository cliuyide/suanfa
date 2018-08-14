package main.liuyi.diameterofbinarytree;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

/**
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/description/
 * 
 * @author liuyi
 *
 */
public class DiameterOfBinaryTree {
	public int temp = 0;
	public int max = 0;
	public static void main(String[] args) {
	}
	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return 0;
		}
		bianli(root);
		return max;
	}

	public void bianli(TreeNode node) {
		if (node == null) {
			return;
		}
		handler(node, node, 0);
		if (temp > max) {
			max = temp;
		}
		temp = 0;
		if (node.left != null) {
			bianli(node.left);
		}

		if (node.right != null) {
			bianli(node.right);
		}

	}
	public int handler(TreeNode root, TreeNode parent, int diameter) {
		if (root.left != null) {
			handler(root.left, parent, diameter + 1);
		}
		if (root.right != null) {
			if (root == parent) {
				diameter = temp;
			}
			handler(root.right, parent, diameter + 1);
		}
		if (root.left == null && root.right == null) {
			if (diameter > temp)
				temp = diameter;
		}
		return temp;
	}
}
