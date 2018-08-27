package main.liuyi.populatingnextrightpointersineachnode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/description/
 * 
 * @author liuyi
 *
 */
public class PopulatingNextRightPointersInEachNode {
	public static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		handler(root, new ArrayList<>(), 0);
	}

	private void handler(TreeLinkNode root, List<TreeLinkNode> list, int depth) {
		TreeLinkNode layer = null;
		if (list.size() > depth) {
			layer = list.get(depth);
			layer.next = root;
			list.set(depth, root);
		} else {
			layer = root;
			list.add(depth, layer);
		}

		if (root.left != null) {
			handler(root.left, list, depth + 1);
		}
		if (root.right != null) {
			handler(root.right, list, depth + 1);
		}
	}
}
