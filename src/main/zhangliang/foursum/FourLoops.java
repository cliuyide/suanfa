package main.zhangliang.foursum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourLoops {

    private static Integer sumArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        Integer result = 0;
        for (int i : arr) {
            result += i;
        }
        return result;
    }

    private static String convert2String(int[] arr) {
        if (arr == null || arr.length == 0) {
            return "";
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder("[");
        for (int i : arr) {
            if (sb.length() > 1) {
                sb.append(",");
            }
            sb.append(i);
        }
        sb.append("]");
        return sb.toString();
    }

    private static void test1() {
        int[] targetArray = new int[] { 1, 0, -1, 0, -2, 2 };
        int targetValue = 0;
        int loop = targetArray.length;
        Set<String> existed = new HashSet<>();
        for (int a = 0; a < loop; a++) {
            for (int b = 0; b < loop; b++) {
                if (b == a) {
                    continue;
                }
                for (int c = 0; c < loop; c++) {
                    if (c == b || c == a) {
                        continue;
                    }
                    for (int d = 0; d < loop; d++) {
                        if (d == c || d == b || d == a) {
                            continue;
                        }
                        int[] arr = new int[] { targetArray[a], targetArray[b], targetArray[c], targetArray[d] };
                        String key = convert2String(arr);
                        Integer sum = sumArray(arr);
                        if (sum != null && sum.equals(targetValue)) {
                            if (!existed.contains(key)) {
                                existed.add(key);
                            }
                        }
                    }
                }
            }
        }
        if (existed != null && !existed.isEmpty()) {
            for (String arr : existed) {
                System.out.println(arr);
            }
        }
    }

    /**
     * 282 / 282 个通过测试用例, 执行用时：343 ms, 已经战胜 3.13 % 的 java 提交记录
     * 
     * @param nums
     * @param target
     * @return
     */
    private List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        Set<String> existed = new HashSet<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {
                    for (int m = k + 1; m < nums.length; m++) {
                        if (nums[i] + nums[j] + nums[k] + nums[m] == target) {
                            if (!existed.contains("" + nums[i] + nums[j] + nums[k] + nums[m])) {
                                existed.add("" + nums[i] + nums[j] + nums[k] + nums[m]);
                                List<Integer> list = new ArrayList<>();
                                list.add(nums[i]);
                                list.add(nums[j]);
                                list.add(nums[k]);
                                list.add(nums[m]);
                                result.add(list);
                            }
                        } else if (nums[i] + nums[j] + nums[k] + nums[m] > target) {
                            break;
                        }
                    }
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
    }
}