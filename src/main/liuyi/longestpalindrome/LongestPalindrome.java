package main.liuyi.longestpalindrome;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class LongestPalindrome {
	public static void main(String[] args) {
		System.out.println(new LongestPalindrome().longestPalindrome("aaaa"));
	}

	public String longestPalindrome(String s) {
		if (s == null) {
			return "";
		}
		if (s.length() == 1) {
			return s;
		}
		if (s.length() == 2 && s.charAt(0) == s.charAt(1)) {
			return s;
		}
		int length = 0;
		int startIndex = 0;
		int endIndex = 0;
		for (int i = 0; i <= s.length(); i++) {
			for (int j = 0; j <= i; j++) {
				if ((i + j) <= s.length()&&(i - j) >=0&&s.charAt(i + j) == s.charAt(i - j)) {
					int startIndexTemp = i - j;
					int endIndexTemp = i + j;
					if ((endIndexTemp - startIndexTemp) > length) {
						startIndex = startIndexTemp;
						endIndex = endIndexTemp;
						length = endIndexTemp - startIndexTemp;
					}
					continue;
				}
				if ((i + j) <= s.length()&&s.charAt(i + j) == s.charAt(i)) {
					int t=j;
					while (i + t < s.length()) {
						int startIndexTemp = i;
						int endIndexTemp = i +t;
						if ((endIndexTemp - startIndexTemp) > length&&s.charAt(i + t) == s.charAt(i)) {
							startIndex = startIndexTemp;
							endIndex = endIndexTemp;
							length = endIndexTemp - startIndexTemp;
						}
						t++;
					}
					continue;
				}

				if ((i - j) >=0&&s.charAt(i - j) == s.charAt(i)) {
					int t=j;
					while (t>0&&i - t >= 0) {
						int startIndexTemp = i - t;
						int endIndexTemp = i;
						if ((endIndexTemp - startIndexTemp) > length&&s.charAt(i - t) == s.charAt(i)) {
							startIndex = startIndexTemp;
							endIndex = endIndexTemp;
							length = endIndexTemp - startIndexTemp;
						}
						t--;
					}
					continue;
				}

				break;
			}
		}
		return s.substring(startIndex, endIndex + 1);
	}
}
