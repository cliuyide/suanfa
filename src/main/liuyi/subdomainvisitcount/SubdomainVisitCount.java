package main.liuyi.subdomainvisitcount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.alibaba.fastjson.JSON;

public class SubdomainVisitCount {
    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new SubdomainVisitCount().subdomainVisits(new String[] { "9001 discuss.leetcode.com" })));
    }
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        List<String> result=new ArrayList<>();
        if(cpdomains.length==0){
            return result;
        }
        for (String item : cpdomains) {
            String[] splitStr = item.split(" ");
            int count = Integer.parseInt(splitStr[0]);
            String[] domains = splitStr[1].split(",");
            String domain = null;
            for (int i = domains.length - 1; i >= 0; i--) {
                domain = domain + "." + domains[i];
                if (map.get(domain) != null) {
                    map.put(domain, map.get(domain) + count);
                } else {
                    map.put(domain, count);
                }
            }
            
        }
        if (!map.isEmpty()) {
            Iterator<Entry<String, Integer>> mapIterator = map.entrySet().iterator();
            while (mapIterator.hasNext()) {
                Entry<String, Integer> next = mapIterator.next();
                result.add(next.getValue() + " " + next.getKey());
            }
        }
        return result;
    }
}
