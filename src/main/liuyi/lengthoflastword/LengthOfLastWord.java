package main.liuyi.lengthoflastword;
//https://leetcode-cn.com/problems/length-of-last-word/description/
public class LengthOfLastWord {
	public static void main(String[] args) {
		new LengthOfLastWord().lengthOfLastWord(" ");
	}
	public int lengthOfLastWord(String s) {
		int result=0;
		if(s==null){
			return  result;
		}
		String[] array = s.split(" ");
		if(array.length==0){
			return result;
		}
		result=array[array.length-1].length();
		return result;
	}
}
