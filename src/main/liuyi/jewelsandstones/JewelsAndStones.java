package main.liuyi.jewelsandstones;

/**
 * https://leetcode-cn.com/problems/jewels-and-stones/description/
 * 
 * @author liuyi
 *
 */
public class JewelsAndStones {
	public int numJewelsInStones(String J, String S) {
		int result = 0;
		int[] tem = new int[256];
		char[] scharArray = S.toCharArray();
		for (int i = 0; i < scharArray.length; i++) {
			tem[scharArray[i]]++;
		}
		for (int i = 0; i < J.toCharArray().length; i++) {
			result += tem[J.charAt(i)];
		}
		return result;
	}
}
