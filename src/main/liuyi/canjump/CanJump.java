package main.liuyi.canjump;
/**
 * https://leetcode-cn.com/problems/jump-game/description/
 * 55
 * @author liuyi
 *
 */
public class CanJump {
	public boolean canJump(int[] nums) {
		if(nums.length==0){
			return false;
		}
		if(nums.length==1){
			return true;
		}
		if(nums[0]==0){
			return false;
		}
		for(int i=0;i<nums.length-1;i++){
			//如果不是0就继续下一个循环
			if(nums[i]!=0){
				continue;
			}
			//如果不是最后一位是0就进入此逻辑
			if(i<nums.length-1){
				for(int j=i-1;j>=0;j--){
					//如果前几位大于该位置到i的长度,则证明这个位置为0没问题,跳出此循环
					if(nums[j]>(i-j)){
						break;
					}else{
						//若第0位都过不去,说明结束了
						if(j==0){
							return false;
						}else{
							continue;
						}
					}
				}
			}
		}
		return true;
	}
}
