package main.hanjinxin.summaryranges;

import java.util.ArrayList;
import java.util.List;

public class SummaryRangesA {
    public static List<String> summaryRanges(int[] nums) {
        if(nums.length <= 0){
            return new ArrayList<>(0);
        }
        List<String> result = new ArrayList<String>();
        int start = nums[0] ;
        int end = nums[0] ;
        for(int i=1; i<nums.length; i++){
            if(nums[i] - end == 1){
                end = nums[i];
            }else{
                result.add(convert2Str(start,end));
                start = nums[i];
                end = nums[i];
            }
        }
        result.add(convert2Str(start,end));
        return result;
    }
    
    private static String convert2Str(int start, int end){
        StringBuffer sb = new StringBuffer();
        if(start == end){
            return sb.append(start).toString(); 
        }else{
            return sb.append(start).append("->").append(end).toString();
        }
    }
    
    public static void main(String[] args) {
        System.out.println(SummaryRangesA.summaryRanges(new int[]{0,1,2,4,5,7}));
    }
}
