package main.hanjinxin.hindex;

public class HIndexBest {
    public int hIndex(int[] citations) {
        int length = citations.length;
        int[] nums = new int[length+1];
        // 引用的数量如果大于了原数组的长度,那么这篇论文的引用数量一定会被所有的h-index运算到
        for(int i=0; i<citations.length; i++){
            if(citations[i] > length){
                nums[length]++;
            }else{
                nums[citations[i]]++;
            }
        }
        
        // nums每一个下标,代表引用的次数,值代表这个引用次数的文档数
        int result = 0;
        for(int i=nums.length-1; i>=0; i--){
            result += nums[i];
            // 反向循环,当总文档数第一次大于等于引用次数时,则值为h-index
            if(result >= i) return i;
        }
        return result;
    }
    
    public static void main(String[] args) {
        HIndexBest a = new HIndexBest();
        System.out.println(a.hIndex(new int[]{3,1,0,6,5}));
    }
}
