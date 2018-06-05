package main.hanjinxin.repeateddnasequences;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/repeated-dna-sequences/description/
 * 
 * 32 / 32 test cases passed. Status: Accepted Runtime: 125 ms
 */
public class RepeatedDNASequencesB {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String,Integer> map = new HashMap<>();
        if(s!=null && s.length()>10){
            for(int i=0; i<=s.length()-10; i++){
                String cmp = s.substring(i, i+10);
                if(map.get(cmp)!=null){
                    map.put(cmp, map.get(cmp)+1);
                }else{
                    map.put(cmp, 1);
                }
            }
        }
        return map.keySet().stream().filter(item -> map.get(item) > 1).collect(Collectors.toList());
    }
    
    public static void main(String[] args) {
        RepeatedDNASequencesB a = new RepeatedDNASequencesB();
        System.out.println(a.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
