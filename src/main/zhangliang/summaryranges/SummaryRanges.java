package main.zhangliang.summaryranges;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public static void main(String[] args) {
        System.out.println(new SummaryRanges().summaryRanges(new int[] { 0, 2, 3, 4, 6, 8, 9 }));
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        if (nums.length == 1) {
            result.add(nums[0] + "");
            return result;
        }
        int start = nums[0];
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - start == index) {
                index++;
            } else {
                if (index > 1) {
                    result.add(start + "->" + nums[i - 1]);
                    index = 1;
                } else {
                    result.add(start + "");
                }
                start = nums[i];
            }
            // 最后一个
            if (i == nums.length - 1) {
                if (index > 1) {
                    result.add(start + "->" + nums[i]);
                } else {
                    result.add(start + "");
                }
            }
        }
        return result;
    }
}
