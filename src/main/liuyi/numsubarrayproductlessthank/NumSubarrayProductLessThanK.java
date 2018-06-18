package main.liuyi.numsubarrayproductlessthank;

import java.util.Arrays;

import com.alibaba.fastjson.JSON;

/**
 * https://leetcode.com/problems/subarray-product-less-than-k/description/
 * 穷举了所有组合不符合题意
 * @author liuyi
 *
 */
public class NumSubarrayProductLessThanK {
	public int result=0;
	public static void main(String[] args) {
		System.out.println(new NumSubarrayProductLessThanK().numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));
	}
	public int numSubarrayProductLessThanK(int[] nums, int k) {
		if(nums.length==0){
			return result;
		}
		Arrays.sort(nums);
		for(int i=1;i<=nums.length;i++){
			int p=1;
			for(int j=0;j<i;j++){
				p*=nums[j];
			}
			if(p>=k)break;
			hander(nums, 0, new Integer[i], 0,k);
		}
		return result;
        
    }
	public void hander(int[] dataList,int dataIndex,Integer[] resultList,int resultIndex,int k){
		int resultLen=resultList.length;
		int resultCount=resultIndex+1;
		if(resultCount>resultLen){
			int p=1;
			for(int j=0;j<resultList.length;j++){
				p*=resultList[j];
			}
			if(p<k){
				System.out.println(JSON.toJSONString(resultList));
				result++;
			}
			return;
		}
		for(int i=dataIndex;i<dataList.length+resultCount-resultLen;i++){
			resultList[resultIndex]=dataList[i];
			hander(dataList, i+1, resultList, resultIndex+1,k);
		}
	}
}
