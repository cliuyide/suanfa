package main.liuyi.repeateddnasequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.alibaba.fastjson.JSON;

/**
 * https://leetcode.com/problems/repeated-dna-sequences/description/
 * 
 * @author liuyi
 *
 */
public class RepeatedDNASequences {
    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new RepeatedDNASequences().findRepeatedDnaSequences("AAAAAAAAAAA")));
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        if(s.length()<10){
            return result;
        }
        for (int i = 0; i <= s.length() - 10; i++) {
            String item = s.substring(i, i + 10);
            if(!set1.contains(item)){
                set1.add(item);
            } else {
                set2.add(item);
            }
        }
        result.addAll(set2);
        return result;
    }
    
}
