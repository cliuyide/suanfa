package main.liuyi.binaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/description/
 * 
 * @author liuyi
 *
 */
public class BinaryTreeLevelOrderTraversal {
	public static void main(String[] args) {
		TreeNode t1=new TreeNode(3);
		TreeNode t2=new TreeNode(9);
		TreeNode t3=new TreeNode(20);
		TreeNode t4=new TreeNode(15);
		TreeNode t5=new TreeNode(7);
		t1.left=t2;
		t1.right=t3;
		t3.left=t4;
		t3.right=t5;
		System.out.println(JSON.toJSONString(new BinaryTreeLevelOrderTraversal().levelOrder(t1)));
	}
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(root==null){
            return result;
        }
		handler(root, 0, result);
        return result;
    }
    
	public void handler(TreeNode root, Integer depth, List<List<Integer>> result) {
		List<Integer> list = null;
		if (result.size() > depth) {
			list = result.get(depth);
		} else {
			list = new ArrayList<>();
			result.add(list);
		}
        if(root.left==null&&root.right==null){
        	list.add(root.val);
        	return;
        }
        if(root.left!=null){
			handler(root.left, depth + 1, result);
        }
        if(root.right!=null){
			handler(root.right, depth + 1, result);
        }
    	list.add(root.val);
    }
}
