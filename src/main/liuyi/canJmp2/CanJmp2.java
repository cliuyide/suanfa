package main.liuyi.canJmp2;
/**
 * https://leetcode-cn.com/problems/jump-game-ii/description/
 * TODO
 * @author liuyi
 *
 */
public class CanJmp2 {
	public static void main(String[] args) {
		System.out.println(new CanJmp2().jump(new int[]{1,2,3}));
	}
	
	public int jump(int[] nums) {
		int result=0;
		if(nums.length==0){
			return result;
		}
		if(nums.length==1){
			return 0;
		}
		result=handle(0, 0, nums[0], nums.length, nums, result);
		//[2,3]这种情况
		if(result==0){
			result=1;
		}
        return result;
    }
	//index 起始位置  theStepNum 当前一共走了几步,nextStep下一次要走的步数
	public int handle(int index,int theStepNum,int nextStep,int arrLength,int[] array,int result){
		System.out.println("index="+index+"theStepNum="+theStepNum+"nextStep="+nextStep+"result="+result);
		//如果当前位置加上下一步长度大于等于数组长度
		int mb = index+nextStep;
		if(mb>=arrLength){
			//第一次,直接赋值为当前的步数
			if(result==0){
				result=theStepNum;
				//当前使用步数比历史步数小
			}else if(theStepNum<result){
				result=theStepNum;
			}
		}
		if(index>arrLength){
			System.out.println("一共用了"+result+"步");
			return result;
		}
		//循环开始
		
		for(int i=1;i<=nextStep;i++){
			if(i+index<arrLength){
				int item=array[i+index];
				result=handle(index+i,theStepNum+1,item,arrLength,array,result);
			}
		}
		
		return result;
	}
}
