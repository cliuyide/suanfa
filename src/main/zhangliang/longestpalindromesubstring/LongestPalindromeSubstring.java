package main.zhangliang.longestpalindromesubstring;

/**
 * 最长回文子串https://leetcode-cn.com/problems/longest-palindromic-substring/description/
 * 
 * @author Administrator
 *
 */
public class LongestPalindromeSubstring {

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(new LongestPalindromeSubstring().longestPalindrome2("caba"));
        System.out.println(System.currentTimeMillis());
    }

    /**
     * 判断字符s是否为回文字符串
     * 
     * @param s
     * @return
     */
    private static boolean isPalindrome(String s) {
        if (s == null) return false;
        int loops = s.length() / 2;
        for (int i = 0; i < loops; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 94 / 94 个通过测试用例, 执行用时：843 ms, 已经战胜 6.10 % 的 java 提交记录
     * 
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 1) return s;
        int sublength = s.length();
        while (sublength > 0) {
            for (int i = 0; i <= s.length() - sublength; i++) {
                String substring = s.substring(i, i + sublength);
                if (isPalindrome(substring)) {
                    return substring;
                }
            }
            sublength--;
        }
        return "";
    }

    /**
     * 
     * 94 / 94 个通过测试用例, 执行用时：29 ms, 已经战胜 78.96 % 的 java 提交记录, 太麻烦了
     * 
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 1) return s;
        int middle = s.length() / 2;
        String substring = "";
        // 奇数回文, 向左查找
        for (int i = middle; i > 0; i--) {
            int leftindex = i - 1;
            int rightindex = i + 1;
            // 如果剩下的最长串都小于当前最长回文就不用继续找了
            if (2 * i < substring.length() - 1) {
                break;
            }
            while (leftindex >= 0 && rightindex <= s.length() - 1) {
                if (s.charAt(leftindex) == s.charAt(rightindex)) {
                    leftindex--;
                    rightindex++;
                } else {
                    break;
                }
            }
            // 新回文比旧回文长
            if (substring.length() < rightindex - leftindex - 1) {
                substring = s.substring(leftindex + 1, rightindex);
            }
        }
        // 奇数回文, 向右查找
        for (int i = middle + 1; i < s.length(); i++) {
            int leftindex = i - 1;
            int rightindex = i + 1;
            // 如果剩下的最长串都小于当前最长回文就不用继续找了
            if (s.length() - i - 1 < (substring.length() - 1) / 2) {
                break;
            }
            while (leftindex >= 0 && rightindex <= s.length() - 1) {
                if (s.charAt(leftindex) == s.charAt(rightindex)) {
                    leftindex--;
                    rightindex++;
                } else {
                    break;
                }
            }
            // 新回文比旧回文长
            if (substring.length() < rightindex - leftindex - 1) {
                substring = s.substring(leftindex + 1, rightindex);
            }
        }
        // 偶数回文，向左查找
        for (int i = middle; i > 0; i--) {
            int leftindex = i - 1;
            int rightindex = i;
            // 如果剩下的最长串都小于当前最长回文就不用继续找了
            if (2 * i < substring.length()) {
                break;
            }
            while (leftindex >= 0 && rightindex <= s.length() - 1) {
                if (s.charAt(leftindex) == s.charAt(rightindex)) {
                    leftindex--;
                    rightindex++;
                } else {
                    break;
                }
            }
            // 新回文比旧回文长
            if (substring.length() < rightindex - leftindex - 1) {
                substring = s.substring(leftindex + 1, rightindex);
            }
        }

        // 偶数回文，向右查找
        for (int i = middle; i < s.length() - 1; i++) {
            int leftindex = i;
            int rightindex = i + 1;
            if ((s.length() - i - 1) * 2 < substring.length()) {
                break;
            }
            while (leftindex >= 0 && rightindex <= s.length() - 1) {
                if (s.charAt(leftindex) == s.charAt(rightindex)) {
                    leftindex--;
                    rightindex++;
                } else {
                    break;
                }
            }
            // 新回文比旧回文长
            if (substring.length() < rightindex - leftindex - 1) {
                substring = s.substring(leftindex + 1, rightindex);
            }
        }
        return substring;
    }
}
