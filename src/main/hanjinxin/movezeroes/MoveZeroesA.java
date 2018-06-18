package main.hanjinxin.movezeroes;

import com.alibaba.fastjson.JSON;

public class MoveZeroesA { // 这种方式没保证顺序
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            while(nums[left]!=0 && left<right){
                left++;
            }
            while(nums[right]==0 && right>left){
                right--;
            }
            if(left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
    }
    
    public static void main(String[] args) {
        MoveZeroesA a = new MoveZeroesA();
        int[] arr = new int[]{0,1,0,3,12};
        a.moveZeroes(arr);
        System.out.println(JSON.toJSONString(arr));
    }
}
