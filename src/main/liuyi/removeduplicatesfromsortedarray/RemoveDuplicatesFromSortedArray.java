package main.liuyi.removeduplicatesfromsortedarray;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/description/
 * @author liuyi
 * 总感觉自己玩赖了 TODO
 */
public class RemoveDuplicatesFromSortedArray {
	public static void main(String[] args) {
		System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(new int[]{1,1,2}));
	}
	public int removeDuplicates(int[] nums) {
		int result=0;
		if(nums.length==1){
			return ++result;
		}
		List<Integer> list=new ArrayList<>();
		for(int i=1;i<nums.length;i++){
			int prev=nums[i-1];
			int now=nums[i];
			if(now==prev){
				list.add(i);
			}
		}
		for(int i=0,index=0;i<nums.length;i++){
			if(!list.contains(i)){
				nums[index]=nums[i];
				index++;
				result++;
			}
		}
		System.out.println(JSON.toJSONString(nums));
		return result;
	}
}
