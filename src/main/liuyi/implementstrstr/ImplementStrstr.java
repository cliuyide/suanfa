package main.liuyi.implementstrstr;
/**
 * 暴力法 //java博大精深
 * @author liuyi
 *
 */
public class ImplementStrstr {
	public static void main(String[] args) {
		System.out.println(new ImplementStrstr().strStr("mississippi",
				"issip"));
		
	}
	public int strStr(String haystack, String needle) {
		int result=0;
		if(haystack==null||needle==null||haystack==""||needle==""){
			return result;
		}
		int i = 0,j=0;
		while(i<haystack.length()&&j<needle.length()){
			if(haystack.charAt(i)==needle.charAt(j)){
				i++;
				j++;
			}else{
				i=i-j+1;
				j=0;
			}
			
		}
		if(j<needle.length()){
			result=-1;
		}else{
			result=i-j;
		}
		return result;
	}
}
