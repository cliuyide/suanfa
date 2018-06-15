package main.hanjinxin.movezeroes;

import com.alibaba.fastjson.JSON;

/*
 * Runtime: 2 ms Your runtime beats 100.00 % of java submissions
 */
public class MoveZeroesBest {
    public void moveZeroes(int[] nums) {
        int insertPos = 0;
        for(int num:nums){
            if(num != 0){
                nums[insertPos++] = num;
            }
        }
        while(insertPos < nums.length){
            nums[insertPos++] = 0;
        }
    }
    
    public static void main(String[] args) {
        MoveZeroesB a = new MoveZeroesB();
        int[] arr = new int[]{0,1,0,3,12};
        a.moveZeroes(arr);
        System.out.println(JSON.toJSONString(arr));
    }
}
