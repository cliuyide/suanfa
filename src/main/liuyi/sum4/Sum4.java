package main.liuyi.sum4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 四数之和https://leetcode-cn.com/problems/4sum/description/，递归方式
 * 
 */
public class Sum4 {
	public static void main(String[] args) {
        new Sum4().fourSum(new int[] {1,0,-1,0,-2,2}, 0);
	}
	
	public static Set<String> set=new HashSet<>(); 
	public static List<List<Integer>> result=new ArrayList<>();
	public static List<Integer> entity=new ArrayList<>();
	public List<List<Integer>> fourSum(int[] nums, int target) {
		int len=nums.length;
		if(len<4){
			return result;
		}
		Arrays.sort(nums);
		if((nums[len-1]+nums[len-2]+nums[len-3]+nums[len-4])<target){
			return result;
		}
		for(int i=0;i<len;i++){
			int num=nums[0];
			nums[0]=nums[i];
			nums[i]=num;
            entity.clear();
			handle( nums,0,1 ,target);
			
			
		}
		return result;
	}
	
	public static void handle(int[] array,int init,int index,int target){
        if (entity.size() == 0 && index + 3 > array.length) {
            return;
        }
		int i=0;
		if(entity.size()==0){
			entity.add(array[init]);
			
		}
        for (i = index; i < array.length; i++) {
        	for(int a:array){
        		System.out.print(a);
                
        	}
        	System.out.println();
			if(entity.size()<4){
				entity.add(array[i]);
			}
			if(entity.size()==4){
				int b=0;
				for(int e:entity){
					b+=e;
				}
				if(b==target){
					String key = makeKey(entity);
					if(!set.contains(key)){
						result.add(new ArrayList<>(entity));
					}
				}
				index++;
                entity.clear();
				handle(array, init, index, target);
			}
		}
	}
	
	public static String makeKey(List<Integer> entity){
		StringBuilder ssb=new StringBuilder();
		for(Integer item:entity){
			ssb.append(item+"_");
		}
		return ssb.toString();
	}
}
