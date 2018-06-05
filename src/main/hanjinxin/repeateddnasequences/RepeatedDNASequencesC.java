package main.hanjinxin.repeateddnasequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * https://leetcode.com/problems/repeated-dna-sequences/description/
 * 
 * 32 / 32 test cases passed. Status: Accepted Runtime: 125 ms
 */
public class RepeatedDNASequencesC {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> seqs = new ArrayList<>();
        Set<Integer> seq = new HashSet<>();
        Set<Integer> repeatedSeq = new HashSet<>();
        // 构建新的字母二进制规则, 由于一个字母占8位, 而这里只有4个字母, 完全可以用2位解决, 这样会省掉很多内存空间, 
        // 00代表A 即十进制的0  01代表C 即十进制的1  10代表G 即十进制的2  11代表T 即十进制的3
        // 由于int是32位, 而需求中的10字符, 是20位, 所以最后用Integer来代表每一个10字符的字符串, 从而以前做法中的String Set直接变成Integer的Set
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        map.put('A',0);
        map.put('C',1);
        map.put('G',2);
        map.put('T',3);
        
        int v = 0;
        for (int i = 0; i < s.length(); i++) {
            // 每次左移两位,并与下一个字母的自定义二进制数进行或操作,即拼接这个字母,最后由于每次拼接之后值需要后20位,所有再与0xfffff进行与操作,来保留最后的20位
            v = (v<<2 | map.get(s.charAt(i))) & 0xfffff; 
            if (i < 9) continue;
            else {
                // 如果repeatedSeq中不重复(即字符串从未比对过) 且 seq中重复(即字符串出现过多次), 则加入到最终结果中
                if (!seq.add(v) && repeatedSeq.add(v))
                    seqs.add(s.substring(i-9, i+1));
            }
        }
        return seqs;
    }
    
    public static void main(String[] args) {
        RepeatedDNASequencesC a = new RepeatedDNASequencesC();
        System.out.println(a.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
