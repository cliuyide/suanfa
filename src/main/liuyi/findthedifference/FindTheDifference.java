package main.liuyi.findthedifference;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * https://leetcode.com/submissions/detail/158445919/
 * 2.06%
 * @author liuyi
 *
 */
public class FindTheDifference {
	public static void main(String[] args) {
		System.out.println(new FindTheDifference().findTheDifference1("ababa","ababaa"));
	}
	/**
	 * 2.06% 大傻逼算法
	 * @param s
	 * @param t
	 * @return
	 */
	public char findTheDifference(String s, String t) {
		List<Character> tList=new ArrayList<>();
		List<Character> sList=new ArrayList<>();
		char[] tArr = t.toCharArray();
		char[] sArr = s.toCharArray();
		for(int i=0;i<tArr.length;i++){
			tList.add(tArr[i]);
		}
		for(int i=0;i<sArr.length;i++){
			sList.add(sArr[i]);
		}
		Iterator<Character> tIterator = tList.iterator();
		while(tIterator.hasNext()){
			Character next = tIterator.next();
			Iterator<Character> sIterator = sList.iterator();
			while(sIterator.hasNext()){
				if(sIterator.next().equals(next)){
					tIterator.remove();
					sIterator.remove();
					break;
				}else{
					return next;
				}
			}
		}
		return tList.get(0);
	}
	
	public char findTheDifference1(String s, String t) {
		char result=0;
		int[] sArr=new int[123];
		int[] tArr=new int[123];
		for(int i=0;i<s.length();i++){
			sArr[s.charAt(i)]++;
		}
		for(int i=0;i<t.length();i++){
			tArr[t.charAt(i)]++;
		}
		for(int i=97;i<123;i++){
			if(sArr[i]!=tArr[i]){
				result=(char) i;
				break;
			}
		}
		return result;
	}
}
