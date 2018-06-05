package main.zhangliang.repeateddna;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 187. 重复的DNA序列 https://leetcode-cn.com/problems/repeated-dna-sequences/description/
 * 
 */
public class RepeatedDNA {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    /**
     * 32 / 32 个通过测试用例, 执行用时：50 ms, 已经战胜 26.83 % 的 java 提交记录
     * 
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() <= 10) {
            return result;
        }
        Set<String> distinct = new HashSet<>();
        Set<String> existed = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (existed.contains(sub) && !distinct.contains(sub)) {
                result.add(sub);
                distinct.add(sub);
            } else {
                existed.add(sub);
            }
        }
        return result;
    }
}
