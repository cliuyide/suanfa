package mergeintervals;/**
 * Created : liuyi
 * Date: 2019/8/5
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuyi
 * @create 2019-08-05 21:02
 **/

public class Solution {
    public static void main(String[] args) {
//        toArrayString(new Solution().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}));
        toArrayString(new Solution().merge(new int[][]{{2, 3}, {4, 5}, {6, 7}, {1, 18}}));
//        toArrayString(new Solution().merge(new int[][]{{1,4},{4,5}}));
//        toArrayString(new Solution().merge(new int[][]{{1, 4}, {5, 6}}));
//        toArrayString(new Solution().merge(new int[][]{{1, 4}, {0, 5}}));
//        toArrayString(new Solution().merge(new int[][]{{1, 4}, {0, 5}, {1, 10}}));
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1) {
            return intervals;
        }
        int length = intervals.length;
        int min = 0;
        int temp[] = null;
        for (int i = 0; i < intervals.length && intervals[i] != null; i++) {
            min = i;
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[j][0] < intervals[min][0]) {
                    min = j;
                }
            }
            temp = intervals[min];
            intervals[min] = intervals[i];
            intervals[i] = temp;
        }
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i] == null) {
                continue;
            }
            for (int j = i - 1; j >= 0; j--) {
                if (intervals[j] != null && intervals[i] != null) {
                    if ((intervals[j][0] >= intervals[i][0] && intervals[j][0] <= intervals[i][1])
                            || (intervals[j][1] >= intervals[i][0] && intervals[j][1] <= intervals[i][1])
                            || (intervals[i][0] >= intervals[j][0] && intervals[i][0] <= intervals[j][1])
                            || (intervals[i][1] >= intervals[j][0] && intervals[i][1] <= intervals[j][1])) {
                        intervals[i][0] = intervals[i][0] < intervals[j][0] ? intervals[i][0] : intervals[j][0];
                        intervals[i][1] = intervals[i][1] < intervals[j][1] ? intervals[j][1] : intervals[i][1];
                        intervals[j] = null;
                        length--;
                    }
                }
            }
        }
        int[][] result = new int[length][2];
        int index = 0;
        for (int[] item : intervals) {
            if (item != null) {
                result[index] = item;
                index++;
            }
        }
        return result;
    }


    private static void toArrayString(int[][] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            System.out.print("[" + intervals[i][0] + ",");
            System.out.print(intervals[i][1] + "]");
        }
        System.out.println();
    }
}
