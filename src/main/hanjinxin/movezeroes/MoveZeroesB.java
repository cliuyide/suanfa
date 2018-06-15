package main.hanjinxin.movezeroes;

import com.alibaba.fastjson.JSON;

/*
 * Runtime: 23 ms  Your runtime beats 11.18 % of java submissions.
 */
public class MoveZeroesB { 
    public void moveZeroes(int[] nums) {
        for(int i=0; i<nums.length; i++){
            int position = i;
            if(nums[i] != 0) continue;
            for(int j=position+1; j<nums.length; j++){
                if(nums[j] != 0){
                    nums[i] = nums[j];
                    nums[j] = 0;
                    break;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        MoveZeroesB a = new MoveZeroesB();
        int[] arr = new int[]{0,1,0,3,12};
        a.moveZeroes(arr);
        System.out.println(JSON.toJSONString(arr));
    }
}
