package com.weirhp.test;

public class Solution {
	public char findTheDifference(String s, String t) {
		char[] ss = s.toCharArray();
		char[] tt = t.toCharArray();
		int[] chaArr = new int[256];
		for (int i = 0; i < ss.length; i++) {
	        chaArr[ss[i]] = chaArr[ss[i]] + 1;
	    }
	    for (int i = 0; i < tt.length; i++) {
	        chaArr[tt[i]] =chaArr[tt[i]]-1;
	        if(chaArr[tt[i]]<0){
	            return tt[i];
	        }
	    }
		return ' ';
	}
	
	
	public static void main(String[] args) {
		new Solution().findTheDifference("ab", "abc");
	}
}

//char ns = get(ss, i);
//char nt = get(tt, i);
//if (aMap[ns] == 0) {
//	aMap[ns] = nt;
//} else if (aMap[ns] != nt) {
//	return false;
//}
//if (bMap[nt] == 0) {
//	bMap[nt] = ns;
//} else if (bMap[nt] != ns) {
//	return false;
//}
