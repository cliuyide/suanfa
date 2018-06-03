package main.liuyi.longestpalindrome;
/**
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 * @author liuyi
 *
 */
public class LongestPalindrome {
	public static void main(String[] args) {
		System.out.println(new LongestPalindrome().longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
	}

	public String longestPalindrome(String s) {
		if (s == null) {
			return "";
		}
		if (s.length() == 1) {
			return s;
		}
		int maxLenth=0;
		String result="";
//		int time=0;
		for(int i=0;i<s.length()-1;i++){
			if(maxLenth<s.length()-i){
				for(int j=i+1;j<s.length();j++){
					String chuan=s.substring(i, j+1);
//					time++;
//					System.out.println(time+"chuan"+maxLenth);
					if(chuan.length()>maxLenth&&isHuiwen(chuan)&&chuan.length()>maxLenth){
						maxLenth=chuan.length();
						result=chuan;
					}
				}
			}
		}
		if(maxLenth==0){
			result=s.substring(0,1);
		}
		return result;
	}
	
	private boolean isHuiwen(String params){
		for(int i=0;i<params.length()/2;i++){
			if(params.charAt(i)==params.charAt(params.length()-i-1)){
				continue;
			}else{
				return false;
			}
		}
		return true;
	}
}
