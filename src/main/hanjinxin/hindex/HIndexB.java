package main.hanjinxin.hindex;

/*
 * https://leetcode.com/problems/h-index/description/
 * 
 * Runtime: 23 ms  Your runtime beats 2.73 % of java submissions
 */

public class HIndexB {
    public int hIndex(int[] citations) {
        int result = 0;
        for(int i=0; i<citations.length; i++){
            int paperNum = 0;
            if(citations[i] > result){
                for(int j=0; j<citations.length; j++){
                    if(citations[j] >= citations[i]){
                        if(paperNum >= citations[i]) break;
                        paperNum++;
                    }
                }
                result = paperNum>result ? paperNum : result;
            }
        }
        return result;
    }   
    
    public static void main(String[] args) {
        HIndexB a = new HIndexB();
        System.out.println(a.hIndex(new int[]{3,0,1,6,5}));
    }
    
}
