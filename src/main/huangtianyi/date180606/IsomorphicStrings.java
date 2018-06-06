package main.huangtianyi.date180606;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 同构字符串
 * https://leetcode.com/problems/isomorphic-strings/description/
 */
public class IsomorphicStrings {

    /**
     * Given two strings s and t, determine if they are isomorphic.
     * Two strings are isomorphic if the characters in s can be replaced to get t.
     * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
     * Example 1:
     * Input: s = "egg", t = "add"
     * Output: true
     * Example 2:
     * Input: s = "foo", t = "bar"
     * Output: false
     * Example 3:
     * Input: s = "paper", t = "title"
     * Output: true
     */
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
    }

    private static boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(chars1[i])) {
                if (chars2[i] != map.get(chars1[i])) {
                    return false;
                }
            } else {
                if (!set.add(chars2[i])) {
                    return false;
                }
                map.put(chars1[i], chars2[i]);
            }
        }
        return true;
    }
}
