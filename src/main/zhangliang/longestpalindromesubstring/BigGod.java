package main.zhangliang.longestpalindromesubstring;

/**
 * 大神解法，没看懂。。。
 */
public class BigGod {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    // 求最长回文子串
    public String longestPalindrome(String str) {
        if (str.length() <= 1) return str;
        char[] characters = str.toCharArray();
        // 用于存放str中最长回文子串所对应的下标
        int[] range = { 0, 1 };
        for (int i = 0; i < characters.length; i++) {
            i = helper(i, characters, range);
        }
        return str.substring(range[0], range[1]);
    }

    private int helper(int index, char[] c, int[] range) {
        int low = index;
        int high = index;
        // 如果遇到相同字符，则high进位，如abba ，这样偶回文子串也可以当做奇回文处理了
        while (high < c.length - 1 && c[high] == c[high + 1]) {
            high++;
        }
        int cursor = high;

        while (high + 1 < c.length && low - 1 >= 0 && c[low - 1] == c[high + 1]) {
            low--;
            high++;
        }
        if (high - low + 1 > range[1] - range[0]) {
            range[0] = low;
            range[1] = high + 1;
        }
        return cursor;
    }
}