package main.liuyi.hIndex;

import java.util.Arrays;

public class HIndex {
	public static void main(String[] args) {
		System.out.println(new HIndex().hIndex(new int[]{1,1}));
	}
	
	public int hIndex(int[] citations) {
		int result=0;
		Arrays.sort(citations);
        for(int i=citations.length-1;i>=0;i--){
        	int tmp=0;
        	for(int a=citations.length-1;a>=0;a--){
        		if(citations[a]>=i+1&&tmp<citations[a]){
        			tmp++;
        		}
        	}
        	if(tmp>=i+1){
        		return tmp;
        	}
        }
        return result;
    }
}
