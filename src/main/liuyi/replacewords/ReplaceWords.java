package main.liuyi.replacewords;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://leetcode-cn.com/problems/replace-words/description/
 * 
 * @author liuyi
 *
 */
public class ReplaceWords {
	public static void main(String[] args) {
		List<String> dict = Stream.of("a", "b", "c").collect(Collectors.toList());
		System.out.println(new ReplaceWords().replaceWords(dict, "aadsfasf absbs bbab cadsfafs"));
	}
	public String replaceWords(List<String> dict, String sentence) {
		// String[] sentenceArray = sentence.split(" ");
		// for (int i = 0; i < sentenceArray.length; i++) {
		// for (int j = 0; j < dict.size(); j++) {
		// if (sentenceArray[i].indexOf(dict.get(j)) != -1) {
		// sentenceArray[i] = dict.get(j);
		// }
		// }
		// }
		// StringBuilder result = new StringBuilder(sentenceArray[0]);
		// for (int i = 1; i < sentenceArray.length; i++) {
		// result.append(" " + sentenceArray[i]);
		// }
		// return result.toString();
		Set<String> set = new HashSet<>(dict);
		String[] array = sentence.split(" ");
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j < array[i].length(); j++) {
				String temp = array[i].substring(0, j);
				if (set.contains(temp)) {
					array[i] = temp;
				}
			}
			result.append(array[i] + " ");
		}
		return result.substring(0, result.length() - 1);
	}
}
