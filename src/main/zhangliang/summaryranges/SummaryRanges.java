package main.zhangliang.summaryranges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SummaryRanges {

    public static void main(String[] args) {
        System.out.println(new SummaryRanges().summaryRanges2(new int[] { 0, 2, 3, 4, 6, 8, 9 }));
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

    /**
     * 拆成两个数组效率更低了
     * 
     * @param nums
     * @return
     */
    public List<String> summaryRanges2(int[] nums) {
        List<String> result = new ArrayList<>();
        int length = nums.length;
        if (nums == null || length == 0) {
            return result;
        }
        if (length == 1) {
            result.add(nums[0] + "");
            return result;
        }
        List<String> result1 = new ArrayList<>();
        List<String> result2 = new ArrayList<>();
        int sublength = length / 2;
        if (length % 2 > 0) {
            sublength = sublength + 1;
        }

        int[] nums1 = Arrays.copyOfRange(nums, 0, sublength);
        int[] nums2 = Arrays.copyOfRange(nums, sublength, length);

        if (nums1.length == 1) {
            result1.add(nums1[0] + "");
        }
        if (nums2.length == 1) {
            result2.add(nums2[0] + "");
        }

        int start1 = nums1[0];
        int start2 = nums2[0];

        int index1 = 1;
        int index2 = 1;
        for (int i = 1; i < sublength; i++) {
            if (nums1[i] - start1 == index1) {
                index1++;
            } else {
                if (index1 > 1) {
                    result1.add(start1 + "->" + nums1[i - 1]);
                    index1 = 1;
                } else {
                    result1.add(start1 + "");
                }
                start1 = nums1[i];
            }
            // 最后一个
            if (i == nums1.length - 1) {
                if (index1 > 1) {
                    result1.add(start1 + "->" + nums1[i]);
                } else {
                    result1.add(start1 + "");
                }
            }

            if (i < nums2.length) {
                if (nums2[i] - start2 == index2) {
                    index2++;
                } else {
                    if (index2 > 1) {
                        result2.add(start2 + "->" + nums2[i - 1]);
                        index2 = 1;
                    } else {
                        result2.add(start2 + "");
                    }
                    start2 = nums2[i];
                }
                // 最后一个
                if (i == nums2.length - 1) {
                    if (index2 > 1) {
                        result2.add(start2 + "->" + nums2[i]);
                    } else {
                        result2.add(start2 + "");
                    }
                }
            }
        }
        String last = result1.get(result1.size() - 1);
        String first = result2.get(0);
        int lastend = 0;
        int laststart = 0;
        int firststart = 0;
        int firstend = 0;
        String[] strings = last.split("->");
        if (strings.length > 1) {
            laststart = Integer.valueOf(strings[0]);
            lastend = Integer.valueOf(strings[1]);
        }else{
            laststart = Integer.valueOf(strings[0]);
            lastend = Integer.valueOf(strings[0]);
        }
        strings = first.split("->");
        if (strings.length > 1) {
            firststart = Integer.valueOf(strings[0]);
            firstend = Integer.valueOf(strings[1]);
        } else {
            firststart = Integer.valueOf(strings[0]);
            firstend = Integer.valueOf(strings[0]);
        }
        if (firststart - lastend == 1) {
            result1.remove(result1.size() - 1);
            result.addAll(result1);
            result2.remove(0);
            result2.add(0, laststart + "->" + firstend);
            result.addAll(result2);
        } else {
            result.addAll(result1);
            result.addAll(result2);
        }
        return result;
    }
}
