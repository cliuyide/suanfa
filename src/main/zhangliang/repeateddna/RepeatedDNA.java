package main.zhangliang.repeateddna;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


/**
 * 187. 重复的DNA序列 https://leetcode-cn.com/problems/repeated-dna-sequences/description/
 * 
 */
public class RepeatedDNA {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    /**
     * 32 / 32 个通过测试用例, 执行用时：44 ms, 已经战胜 48.78 % 的 java 提交记录
     * 
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() <= 10) {
            return result;
        }
        HashSet<String> distinct = new HashSet<>();
        HashSet<String> existed = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (!existed.add(sub)) {
                if (distinct.add(sub)) {
                    result.add(sub);
                }
            }
        }
        return result;
    }
}