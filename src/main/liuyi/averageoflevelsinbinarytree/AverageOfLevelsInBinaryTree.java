package main.liuyi.averageoflevelsinbinarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.alibaba.fastjson.JSON;
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
/**
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/description/
 * @author liuyi
 *
 */
public class AverageOfLevelsInBinaryTree {
	
	public static void main(String[] args) {
		TreeNode t1=new TreeNode(1);
		TreeNode t2=new TreeNode(1);
//		TreeNode t3=new TreeNode(20);
//		TreeNode t4=new TreeNode(15);
//		TreeNode t5=new TreeNode(7);
		t1.left=t2;
//		t1.right=t3;
//		t3.left=t4;
//		t3.right=t5;
		System.out.println(JSON.toJSONString(new AverageOfLevelsInBinaryTree().averageOfLevels(t1)));
	}
	

	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> result=new ArrayList<>();
		result.add((double)root.val);
		if(root.left==null&&root.right==null){
			return result;
		}
		Map<Integer,List<TreeNode>> params=new HashMap<>();
		handle(1, root, params);
		Set<Entry<Integer, List<TreeNode>>> entrySet = params.entrySet();
		for(Entry<Integer, List<TreeNode>> item:entrySet){
			if(item.getValue().size()>0){
				double sum=0;
				for(TreeNode t:item.getValue()){
					sum+=t.val;
				}
				result.add(sum/item.getValue().size());
			}
		}
		return result;
	}

	private void handle(int depth,TreeNode root,Map<Integer,List<TreeNode>> params){
		List<TreeNode> list=params.get(depth);
		if(list==null){
			list=new ArrayList<>();
			params.put(depth, list);
		}
		if(root.left!=null){
			list.add(root.left);
			handle(depth+1, root.left, params);
		}
		if(root.right!=null){
			list.add(root.right);
			handle(depth+1, root.right, params);
		}
	}
	
 
}
