package main.liuyi.maxconsecutiveones;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        System.out.println(new MaxConsecutiveOnes().findMaxConsecutiveOnes(new int[] { 1, 1, 0, 1, 1, 1 }));
    }
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        if (nums.length == 0) {
            return max;
        }
        int continuous = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 1) {
                continue;
            }
            if (i == 0 && nums[i] == 1) {
                continuous++;
                continue;
            }
            if (nums[i] == nums[i - 1]) {
                continuous++;
            } else {
                max = continuous > max ? continuous : max;
                continuous = 0;
                if (nums[i] == 1) {
                    continuous++;
                    continue;
                }
            }
        }
        max = continuous > max ? continuous : max;
        return max;
    }
}
