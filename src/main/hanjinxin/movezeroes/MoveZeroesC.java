package main.hanjinxin.movezeroes;

import com.alibaba.fastjson.JSON;

/*
 * Runtime: 3 ms  Your runtime beats 85.91 % of java submissions
 */
public class MoveZeroesC { // 跟B方案相比,j每一次都记录了上一次的结束点
    public void moveZeroes(int[] nums) {
        int position = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0) continue;
            if(position == 0) position = i;
            for(int j=position+1; j<nums.length; j++){
                if(nums[j] != 0){
                    nums[i] = nums[j];
                    nums[j] = 0;
                    position = j;
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
