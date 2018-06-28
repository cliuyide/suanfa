package main.liuyi.canJmp2;
/**
 * https://leetcode-cn.com/problems/jump-game-ii/description/
 * TODO
 * @author liuyi
 *
 */
public class CanJmp3 {
	public static void main(String[] args) {
		System.out.println(new CanJmp3().jump(new int[]{4,1,1,3,1,1,1}));
	}
	
	public int jump(int[] nums) {
		int result=0;
		if(nums.length==0){
			return result;
		}
		if(nums.length==1){
			return result;
		}
		int length =nums.length;
		int i=0;
		while(true){
			result++;
			if(i<length){
				if(nums[i]+i<length-1){
 					int maxIndex=0;
					for(int j=i+1;j<=i+nums[i];j++){
						if(maxIndex==0){
							maxIndex=j;
						}else if(nums[j]+j>nums[maxIndex]+maxIndex){
							System.out.println("max="+j+"|"+(nums[j]+j));
							maxIndex=j;
						}
					}
					System.out.println("max="+maxIndex);
					i=maxIndex;
				}else{
					break;
				}
			}else{
				break;
			}
		}
		return result;
	}
	
}
