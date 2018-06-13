package main.liuyi.subdomainvisitcount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.alibaba.fastjson.JSON;
/**
 * https://leetcode.com/problems/subdomain-visit-count/description/
 * @author liuyi
 *
 */
public class SubdomainVisitCount {
    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new SubdomainVisitCount().subdomainVisits(new String[] {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"})));
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
            String[] domains = splitStr[1].trim().split("\\.");
            String domain = "";
            for (int i = domains.length - 1; i >= 0; i--) {
            	if(domain==""){
            		domain=domains[i];
            	}else{
            		domain = domains[i]+ "."+domain ;
            	}
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
