package validatestacksequences;/**
 * Created : liuyi
 * Date: 2019/7/11
 */

import java.util.Stack;

/**
 * @author liuyi
 * @create 2019-07-11 23:41
 **/

public class Solution {
    public static void main(String[] args) {
        new Solution().validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1});
        System.out.println();
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> handle = new Stack<>();
        int pu = 0;
        for (int po = 0; po < popped.length; ) {
            while (pu <= pushed.length && po < popped.length) {
                //如果此時棧頂值等于pop数组前列值
                if (handle.size() > 0 && handle.peek() == popped[po]) {
                    handle.pop();
                    po++;
                } else {
                    handle.push(pushed[pu]);
                    pu++;
                }
            }
        }
        if (handle.size() > 0) {
            return false;
        }
        return true;
    }
}
