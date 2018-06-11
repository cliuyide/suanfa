package main.zhangliang.isomorphicstrings;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/isomorphic-strings/description/
 */
public class IsomorphicStrings {

	public static void main(String[] args) {
        new IsomorphicStrings().isIsomorphic2("adsf", "asdf");
	}

    /**
     * 30 / 30 test cases passed, Runtime: 22 ms, Your runtime beats 51.11 % of java submissions
     * 
     * @param s
     * @param t
     * @return
     */
	public boolean isIsomorphic(String s, String t) {
		if (s == null || t == null || s.length() != t.length()) {
			return false;
		}
		boolean result = true;
		Map<Character, Character> map1 = new HashMap<>();
		Map<Character, Character> map2 = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			Character s1 = map1.get(s.charAt(i));
			Character t1 = map2.get(t.charAt(i));
			if (s1 == null) {
				if (t1 != null) {
					result = false;
					break;
				}
				map1.put(s.charAt(i), t.charAt(i));
				map2.put(t.charAt(i), s.charAt(i));
			} else {
				if (t1 == null || t1 != s.charAt(i)) {
					result = false;
					break;
				}
			}
		}
		return result;
	}

    /**
     * 30 / 30 test cases passed, Runtime: 3 ms, Your runtime beats 99.58 % of java submissions
     * 
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic2(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        boolean result = true;
        int[] arr1 = new int[255];
        int[] arr2 = new int[255];
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        for (int i = 0; i < sarr.length; i++) {
            if (arr1[sarr[i]] == 0) {
                if (arr2[tarr[i]] == 0) {
                    arr1[sarr[i]] = tarr[i];
                    arr2[tarr[i]] = sarr[i];
                } else {
                    return false;
                }
            } else {
                if (arr1[sarr[i]] != tarr[i]) {
                    return false;
                }
            }
        }
        return result;
    }
}
