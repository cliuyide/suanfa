package main.hanjinxin.repeateddnasequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * https://leetcode.com/problems/repeated-dna-sequences/description/
 * 
 * 32 / 32 test cases passed. Status: Accepted Runtime: 45 ms Your runtime beats 65.68 % of java submissions
 */
public class RepeatedDNASequencesA { 
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        Set<String> existed = new HashSet<>();
        Set<String> resultSet = new HashSet<>();
        if(s!=null && s.length()>10){
            for(int i=0; i<=s.length()-10; i++){
                String cmp = s.substring(i, i+10);
                if(!existed.contains(cmp)){
                    existed.add(cmp); 
                }else{
                    if(resultSet.add(cmp)){
                        result.add(cmp);
                    }
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        RepeatedDNASequencesA a = new RepeatedDNASequencesA();
        System.out.println(a.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
