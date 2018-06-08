package main.zhangliang.isomorphicstrings;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/isomorphic-strings/description/
 */
public class IsomorphicStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    /**
     * @param s
     * @param t
     * @return
     */
	public boolean isomorphic(String s, String t) {
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
}
