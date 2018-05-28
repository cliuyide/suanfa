package main.liuyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sum4 {
	public static void main(String[] args) {
        new Sum4().fourSum(new int[] { -2, -1, 0, 0, 1, 2 }, 0);
	}
	
	public static Set<String> set=new HashSet<>(); 
	public static List<List<Integer>> result=new ArrayList<>();
	public static List<Integer> entity=new ArrayList<>();
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result=new ArrayList<>();
		int len=nums.length;
		if(len<4){
			return result;
		}
		Arrays.sort(nums);
		if((nums[len-1]+nums[len-2]+nums[len-3]+nums[len-4])<target){
			return result;
		}
		for(int i=0;i<=len-4;i++){
            entity = new ArrayList<>();
			handle( nums,i,i+1 ,target);
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
			if(entity.size()==4){
                entity.forEach(item -> {
                    System.out.print(item);
                });
                System.out.println();
				int b=0;
				for(int e:entity){
					b+=e;
				}
				if(b==target){
					String key = makeKey(entity);
					if(!set.contains(key)){
						result.add(entity);
					}
				}
				index++;
                entity = new ArrayList<>();
				handle(array, init, index, target);
			}else{
				entity.add(array[i]);
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
