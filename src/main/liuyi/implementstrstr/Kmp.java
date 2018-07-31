package main.liuyi.implementstrstr;


public class Kmp {
	public static void main(String[] args) {
		Long start=System.currentTimeMillis();
		System.out.println(new Kmp().strStr("aabaaabaaac",
				"aabaaac"));
		System.out.println(System.currentTimeMillis()-start);
	}

	public int strStr(String haystack, String needle) {
		int result=0;
		if(needle.length()==0){
			return result;
		}
		if(haystack.length()==0||needle.length()>haystack.length()){
			result=-1;
			return result;
		}
		
		int[] nextArr = getNext(needle);
		int i=0,j=0;
		for(;i<haystack.length()&&j<needle.length();){
			if(haystack.charAt(i)==needle.charAt(j)){
				i++;
				j++;
			}else{
				if(j!=0){
					j=nextArr[j-1];
				}else{
					i++;
				}
				
			}
		}
		if(j<needle.length()){
			result=-1;
		}else{
			result=i-j;
		}
		return result;
	}
	
	public int[] getNext(String needle){
		int[] nextArr=new int[needle.length()];
		nextArr[0]=0;
		int j=0,i=1;
		int len=0;
		while(i<needle.length()){
			if(needle.charAt(j)==needle.charAt(i)){
				len++;
				nextArr[i]=len;
				j++;
				i++;
			}else{
				if(j!=0){
					j=nextArr[j-1];
					len=j;
				}else{
					len=0;
					i++;
					continue;
				}
			}
		}
		return nextArr;
	}
}
