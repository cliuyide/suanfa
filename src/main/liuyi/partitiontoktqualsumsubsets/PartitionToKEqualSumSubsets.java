package main.liuyi.partitiontoktqualsumsubsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class PartitionToKEqualSumSubsets {
	public static void main(String[] args) {
		System.out.println(new PartitionToKEqualSumSubsets().canPartitionKSubsets(new int[]{4,15,1,1,1,1,3,11,1,10}, 3));
	}
	public boolean canPartitionKSubsets(int[] nums, int k) {
        boolean result=false;
        if(nums.length<k||k==0){
        	return result;
        }
        if(k==1&&nums.length>0){
        	return true;
        }
        //求总数
        int sum=0;
        for(int i=0;i<nums.length;i++){
        	sum+=nums[i];
        }
        //余数不等于0 返回false
        int remainder=sum%k;
        if(remainder!=0){
        	return result;
        }
        //排序
        Arrays.sort(nums);
        //求平均值
        int avg=sum/k;
        //最大数比平均数大，返回false
        if(nums[nums.length-1]>avg){
        	return result;
        }
        //放入list中方便操作
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
        	list.add(nums[i]);
        }
        int equalsAvgCount=0;
        
        for(int i=list.size()-1;i>0;i--){
        	//超过平均数以上 数组还有剩余，返回false
        	if(equalsAvgCount>k){
        		return result;
        	}
        	if(list.get(i)>avg){
        		return result;
        		//将数组中所有等于平均数的干掉同时符合的数量++
        	}else if(list.get(i)==avg){
        		equalsAvgCount++;
        		list.remove(i);
        	}
        }
//        k=k-equalsAvgCount;
//        while(k>0&&list.size()>0){
//        	int temp=avg;
//        	int i=0;
//        	while(temp>0&&i<list.size()){
//        		temp-=list.get(i);
//        		System.out.println(JSON.toJSONString(list));
//        		if(temp==0){
//        			list.remove(i);
//        			k--;
//        		}else if(temp>0){
//        			list.remove(i);
//            		int tem=list.indexOf(temp);
//            		if(tem!=-1){
//            			temp-=list.get(tem);
//            			list.remove(tem);
//            			k--;
//            		}
//        		}else{
//        			return result;
//        		}
//        		
//        	}
//        }
//        if(k>0||list.size()>0){
//        	return result;
//        }
        result=true;
        return result;
    }
}
