package main.hanjinxin.hindex;

/*
 * https://leetcode.com/problems/h-index/description/
 * 
 * Runtime: 8 ms  Your runtime beats 5.95 % of java submissions
 */

public class HIndexA {
    public int hIndex(int[] citations) {
        quickSort(citations, 0, citations.length-1);
        int result = 0;
        for(int i=citations.length-1; i>=0; i--){
            if(citations[i] >= i || citations.length-i>=citations[i]){
                int temp = citations.length-i>citations[i] ? citations[i] : citations.length-i;
                if(temp <= result) break;
                result = temp ;
            }
        }
        return result;
    }   
    
    public void quickSort(int[] array, int left, int right){
        int tempLeft = left; 
        int tempRight = right;
        if(left <= right){
            int temp = array[tempLeft]; // 基准元素
            while(tempLeft != tempRight){
                while(tempRight>tempLeft && array[tempRight]>=temp){
                    tempRight--;
                }
                array[tempLeft] = array[tempRight];
                
                while(tempLeft<tempRight && array[tempLeft]<=temp){
                    tempLeft++;
                }
                array[tempRight] = array[tempLeft];
            }
            array[tempLeft] = temp; // 将基准元素赋值到最后的位置
            quickSort(array, left, tempLeft-1);
            quickSort(array, tempLeft+1, right);
        }
    }
    
    public static void main(String[] args) {
        HIndexA a = new HIndexA();
        System.out.println(a.hIndex(new int[]{100}));
    }
    
}
