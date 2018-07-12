package main.zhangliang.maxdistance;

/**
 * https://leetcode-cn.com/problems/maximize-distance-to-closest-person/description/
 * 
 */
public class MaxDistance {
    /**
     * 79 / 79 个通过测试用例, 执行用时：7 ms
     * 
     * @param seats
     * @return
     */
    public int maxDistToClosest(int[] seats) {
        int distance = 0;
        int start = 0;
        // 数组以0开头
        for (; start < seats.length; start++) {
            if (seats[start] == 1) {
                distance = start;
                break;
            }
        }
        // 以0结尾
        int end = seats.length - 1;
        for (; end >= 0; end--) {
            if (seats[end] == 1) {
                if (seats.length - end - 1 > distance) {
                    distance = seats.length - end - 1;
                }
                break;
            }
        }
        // 和连续1的个数算法一样
        if (end > start) {
            int max = 0;
            int current = 0;
            for (int i = start + 1; i < end; i++) {
                if (seats[i] == 0) {
                    current++;
                } else {
                    if (current > max) {
                        max = current;
                    }
                    current = 0;
                }
            }
            if (current > max) {
                max = current;
            }
            max = (max + 1) / 2;
            if (max > distance) {
                distance = max;
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        System.out.println(new MaxDistance().maxDistToClosest(new int[] { 1, 0, 0, 0 }));
    }

}
