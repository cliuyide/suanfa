package main.liuyi.averageoflevelsinbinarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/description/
 */
import com.alibaba.fastjson.JSON;
public class AverageOfLevelsInBinaryTree2 {
	
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
		System.out.println(JSON.toJSONString(new AverageOfLevelsInBinaryTree2().averageOfLevels(t1)));
	}
	

	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> result=new ArrayList<>();
		List<Integer> count=new ArrayList<>();
		handle(0, root, result,count);
		for(int i=0;i<result.size();i++){
			result.set(i, result.get(i)/count.get(i));
		}
		return result;
	}

	private void handle(int depth,TreeNode root,List<Double> result,List<Integer> count){
		if(root==null){
			return;
		}
		if(depth>=result.size()){
			result.add(depth,1.0*root.val);
			count.add(depth,1);
		}else{
			result.set(depth,result.get(depth)+root.val);
			count.set(depth,count.get(depth)+1);
		}
		handle(depth+1, root.left, result, count);
		handle(depth+1, root.right, result, count);
	}
}
