package main.huangtianyi.date180605;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 重复的DNA序列
 * https://leetcode.com/problems/repeated-dna-sequences/description/
 */
public class RepeatedDNASequences {

    /**
     * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
     * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
     * Example:
     * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
     * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
     */
    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }

    private static List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) {
            return result;
        }
        Set<String> dnaSet = new HashSet<>();
        Set<String> resultSet = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String dnaStr = s.substring(i, i + 10);
            if (!dnaSet.add(dnaStr)) {
                resultSet.add(dnaStr);
            }
        }
        for (String entry : resultSet) {
            result.add(String.valueOf(entry));
        }
        return result;
    }
}
