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
        System.out
                .println(new LongestPalindromeSubstring()
                        .longestPalindrome("ababa"));
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
}
