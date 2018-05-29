package main.liuyi.validtrianglenumber;

import java.util.Arrays;
/**
 * https://leetcode.com/problems/valid-triangle-number/description/
 * @author liuyi
 *
 */
public class ValidTriangleNumber {
	public static void main(String[] args) {
		System.out.println(new ValidTriangleNumber().triangleNumber(new int[]{7,34,95,77,57,99,94,1,2,47,49,55,66,59,24,41,31,67,46,58,51,75,64,39,14,36,7,8,12,5,2,60,76,25,3,50,89,82,45,24,22,4,5,24,47,49,19,24,4,71,9,36,48,94,16,2,46,85,38,18,78,33,70,41,88,24,47,24,1,80,28,34,88,20,95,58,0,79,60,61,73,58,5,7,59,29,90,45,13,88,23,15,91,82,67,23,91,14,40,5}));
	}
	public int triangleNumber(int[] nums) {
		int result=0;
		if(nums.length<3){
			return result;
		}
		Arrays.sort(nums);
		for(int i=0;i<nums.length-2;i++){
			for(int j=i+1;j<nums.length-1;j++){
				for(int p=j+1;p<nums.length;p++){
					if((nums[i]+nums[j])>nums[p]){
						result++;
					}
				}
			}
		}
		return result;
	}
}
