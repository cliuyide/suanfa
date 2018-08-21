package liuyi.binaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
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
		new BinaryTreeLevelOrderTraversal().levelOrder(t1);
	}
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(root==null){
            return result;
        }
        Map<Integer,List<Integer>> map=new HashMap<Integer, List<Integer>>();
        handler(root,0,map);
        map.entrySet().forEach(entry->result.add(entry.getValue()));
        return result;
    }
    
    public void handler(TreeNode root,Integer depth,Map<Integer,List<Integer>> map){
        if(root.left==null&&root.right==null){
        	List<Integer> list=map.get(depth);
        	if(list==null){
        		list=new ArrayList<Integer>(){};
        		map.put(depth, list);
        	}
        	list.add(root.val);
        	return;
        }
        if(root.left!=null){
            handler(root.left,depth+1,map);
        }
        if(root.right!=null){
            handler(root.right,depth+1,map);
        }
        List<Integer> list=map.get(depth);
    	if(list==null){
    		list=new ArrayList<Integer>(){};
    		map.put(depth, list);
    	}
    	list.add(root.val);
    }
}
