package main.liuyi.findallduplicatesinanarray;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/description/
 * 
 * @author liuyi
 *
 */
public class FindAllDuplicatesInAnArray {
    public static void main(String[] args) {
        new FindAllDuplicatesInAnArray().findDuplicates(new int[] { 3, 11, 8, 16, 4, 15, 4, 17, 14, 14, 6, 6, 2, 8, 3, 12, 15, 20, 20, 5 });
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length;) {
            int val = nums[i];
            int targetVal = nums[val - 1];
            if (val == i + 1 || val != targetVal) {
                if (val != targetVal) {
                    nums[val - 1] = val;
                    nums[i] = targetVal;
                    i--;
                }
                i++;
            }else{
                i++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            int targetVal = nums[val - 1];
            if (val != i + 1 && val == targetVal) {
                result.add(val);
            }
        }
        return result;
    }
}
