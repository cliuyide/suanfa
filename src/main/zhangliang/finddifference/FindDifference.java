package main.zhangliang.finddifference;

import java.util.Arrays;

public class FindDifference {

	/**
	 * 10ms, 37%
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public char findTheDifference(String s, String t) {
		if (s == null || t == null) {
			return ' ';
		}
		char[] arrS = s.toCharArray();
		char[] arrT = t.toCharArray();

		Arrays.sort(arrS);
		Arrays.sort(arrT);
		for (int i = 0; i < s.length(); i++) {
			if (arrS[i] != arrT[i]) {
				return arrT[i];
			}
		}
		return arrT[arrT.length - 1];
	}

	/**
	 * 6-8ms, 64%
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public char findTheDifference2(String s, String t) {
		if (s == null || t == null) {
			return ' ';
		}
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum = sum + t.charAt(i) - s.charAt(i);
		}
		return (char) (sum + t.charAt(t.length() - 1));
	}

	/**
	 * 6-8ms, 99%
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public char findTheDifference3(String s, String t) {
		if (s == null || t == null) {
			return ' ';
		}
		int sum = 0;
		char[] arrS = s.toCharArray();
		char[] arrT = t.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			sum = sum + arrT[i] - arrS[i];
		}
		if (sum == 0) {
			return arrT[t.length() - 1];
		} else {
			return (char) (sum + arrT[t.length() - 1]);
		}
	}
}
