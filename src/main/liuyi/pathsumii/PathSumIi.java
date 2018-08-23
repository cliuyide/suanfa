package main.liuyi.pathsumii;

import java.util.ArrayList;
import java.util.List;


/**
 * https://leetcode-cn.com/problems/path-sum-ii/description/
 * 
 * @author liuyi
 *
 */
public class PathSumIi {
	public static void main(String[] args) {
		TreeNode a = new TreeNode(-2);
		TreeNode a2 = new TreeNode(-3);
		a.right = a2;
		new PathSumIi().pathSum(a, -5);
	}
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		handler(root, 0, sum, new int[] {}, result);
		return result;
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}

	private void handler(TreeNode root, int tmpsum, int sum, int[] tmpArray, List<List<Integer>> result) {
		tmpsum += root.val;
		int[] tmpArray2 = new int[tmpArray.length + 1];
		System.arraycopy(tmpArray, 0, tmpArray2, 0, tmpArray.length);
		tmpArray2[tmpArray.length] = root.val;
		if (root.left == null && root.right == null) {
			if (tmpsum == sum) {
				List<Integer> l = new ArrayList<>();
				for (int i = 0; i < tmpArray2.length; i++) {
					l.add(tmpArray2[i]);
				}
				result.add(l);
				return;
			}
		}

		if (root.left != null) {
			handler(root.left, tmpsum, sum, tmpArray2, result);
		}
		if (root.right != null) {
			handler(root.right, tmpsum, sum, tmpArray2, result);
		}
	}
}
