package main.houpo.moveZeroes;
public class moveZeroes {
	
    public void moveZeroes(int[] nums) {
        int nowIndex = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0){
                nums[nowIndex] = nums[i];
                nowIndex ++;
            }
        }
        for(int j=nowIndex;j<nums.length;j++){
            nums[j] = 0;
        }
    }
}
