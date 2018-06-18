package main.liuyi.numsubarrayproductlessthank;

import java.util.Arrays;

import com.alibaba.fastjson.JSON;

/**
 * TODO 超时！！
 * https://leetcode.com/problems/subarray-product-less-than-k/description/
 * @author liuyi
 *
 */
public class NumSubarrayProductLessThanK2 {
	public int result=0;
	public static void main(String[] args) {
		System.out.println(new NumSubarrayProductLessThanK2().numSubarrayProductLessThanK(new int[]{15,4,13,33,1,19,26,17,14,28,6,7,6,14,7,1,8,8,31,1,12,20,22,20,21,6,7,33,2,30,3,18,17,23,16,7,32,24,21,33,11,15,31,33,21,9,2,2,14,10,11,2,26,20,19,12,32,32,6,21,20,24,16,19,27,10,32,18,13,20,6,17,32,24,7,32,15,28,18,30,15,13,24,29,33,23,33,19,20,15,26,33,9,16,19,29,20,2,30,15,12,9,10,20,4,23,8,25,13,19,24,33,6,20,32,18,33,20,26,4,17,13,9,6,2,32,8,28,6,4,19,15,1,14,27,29,22,28,18,3,25,29,26,14,31,18,5,10,19,5,11,24,26,3,11,6,22,21,21,23,6,6,3,23,2,14,9,8,9,8,28,9,18,31,22,1,29,31,11,7,33,18,24,14,13,13,15,9,10,29,14,4,31,13,18,28,20,3,27,8,15,18,7,10,23,3,20,9,15,10,29,16,24,13,28,27,26,22,20,25,12,29,1,27,5,29,32,26,26,25,3,19,28,7,31,33,20,7,25,1,21,16,22,26,19,32,7,16,21,24,28,31,12,18,31,3,18,18,23,23,26,22,18,5,9,33,32,26,33,22,17,9,3,17,31,27,8,10,18,17,9,29,9,33,1,5,17,19,10,31,8,13,28,20,17,19,3,4,16,5,5,5,25,3,23,27,11,27,20,3,30,9,17,2,2,24,29,22,1,2,15,12,28,12,29,21,6,22,5,27,16,9,23,10,27,18,14,22,6,23,3,23,5,2,30,24,11,26,11,16,5,32,7,15,6,25,1,29,31,4,18,30,7,9,10,25,28,3,23,1,6,33,27,21,25,1,17},1409));
	}
	public int numSubarrayProductLessThanK(int[] nums, int k) {
		if(nums.length==0){
			return result;
		}
		for(int i=1;i<=nums.length;i++){
			hander(nums, 0, i,k);
		}
		return result;
        
    }
	public void hander(int[] dataList,int dataIndex,int resultLen,int k){
		if(dataIndex>dataList.length-resultLen){
			return ;
		}
		Long p=1L;
		for(int i=dataIndex;p<k&&i<resultLen+dataIndex;i++){
			p=p*dataList[i];
		}
		if(p<k){
			result++;
		}
		hander(dataList, ++dataIndex, resultLen, k);
	}
}
