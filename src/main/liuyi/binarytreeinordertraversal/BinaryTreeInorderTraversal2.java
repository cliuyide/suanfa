package main.liuyi.binarytreeinordertraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.alibaba.fastjson.JSON;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/
 * 迭代
 * 
 * @author liuyi
 *
 */
public class BinaryTreeInorderTraversal2 {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode root2 = new TreeNode(2);
		TreeNode root3 = new TreeNode(3);
		root.right = root2;
		root2.left = root3;
		System.out.println(JSON.toJSONString(new BinaryTreeInorderTraversal2().inorderTraversal(root)));
	}
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				TreeNode parent = stack.pop();
				result.add(parent.val);
				root = parent.right;
			}
		}
		return result;
	}

}
