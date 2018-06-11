package main.zhangliang.subdomainvisits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * https://leetcode.com/problems/subdomain-visit-count/description/
 */
public class SubdomainVisits {

    public static void main(String[] args) {
        System.out.println(new SubdomainVisits().subdomainVisits(new String[] { "9001 discuss.leetcode.com" }));
    }

    /**
     * 52 / 52 test cases passed.Runtime: 28 ms
     * 
     * @param cpdomains
     * @return
     */
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        if (cpdomains != null && cpdomains.length > 0) {
            for (String cpdomain : cpdomains) {
                countDomainVisists(cpdomain, map);
            }
        }
        Iterator<Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<String, Integer> entry = iterator.next();
            result.add(entry.getValue() + " " + entry.getKey());
        }
        return result;
    }

    private static void countDomainVisists(String cpdomain, Map<String, Integer> map) {
        String[] arr = cpdomain.split(" ");
        Integer count = Integer.valueOf(arr[0]);
        cpdomain = arr[1];
        Integer existedCount = map.get(cpdomain);
        if (existedCount == null) {
            map.put(cpdomain, count);
        } else {
            map.put(cpdomain, count + existedCount);
        }
        while (true) {
            int index = cpdomain.indexOf(".");
            if (index < 0) break;
            cpdomain = cpdomain.substring(index + 1);
            existedCount = map.get(cpdomain);
            if (existedCount == null) {
                map.put(cpdomain, count);
            } else {
                map.put(cpdomain, count + existedCount);
            }
        }
    }
}