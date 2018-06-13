package main.zhangliang.HIndex;

import java.util.Arrays;

public class HIndex {
    /**
     * 82 / 82 test cases passed,Runtime: 9 ms, Your runtime beats 5.60 % of java submissions
     */
    public int hIndex(int[] citations) {
        if (citations == null) {
            return 0;
        }
        int length = citations.length;
        // 正序
        Arrays.sort(citations);
        for (int i = 0; i < length; i++) {
            if (length - i <= citations[i]) {
                return length - i;
            }
        }
        return 0;
    }

    /**
     * 82 / 82 test cases passed,Runtime: 8 ms, Your runtime beats 5.95 % of java submissions
     */
    public int hIndex2(int[] citations) {
        if (citations == null) {
            return 0;
        }
        // 正序
        Arrays.sort(citations);
        int left = 0;
        int right = citations.length - 1;
        int h = 0;
        while (right >= left) {
            // 取右半侧
            int middle = (left + right) / 2;
            if (citations.length - middle > citations[middle]) {
                left = middle + 1;
            } else {
                h = citations.length - middle;
                right = middle - 1;
            }
            if (middle == left) {
                break;
            }
        }
        return h;
    }

    public static void main(String[] args) {
        System.out.println(new HIndex().hIndex2(new int[] { 0, 1 }));
    }
}
