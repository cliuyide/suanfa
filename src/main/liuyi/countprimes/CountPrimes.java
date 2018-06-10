package main.liuyi.countprimes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.alibaba.fastjson.JSON;

public class CountPrimes {
	public static void main(String[] args) {
		System.out.println(new CountPrimes().countPrimes(499979));
	}
	private List<Integer> set=new ArrayList<>();
	private int count=0;
	public int countPrimes(int n) {
        int countPrimes=0;
        if(n<=2){
        	return 0;
        }
        countPrimes=1;
        set.add(2);
        for(int i=3;i<n;i=i+2){
        	if(i%5==0){
        		continue;
        	}
        	if(validPrimes(i)){
        		set.add(i);
        		countPrimes++;
        	}
        }
        System.out.println(JSON.toJSONString(set));
        System.out.println(count);
        return countPrimes;
    }
	
	private Boolean validPrimes(int n){
		for(Integer i:set){
			count++;
			if(n%i==0||i>=n){
				return false;
			}
		}
		return true;
	}
	
}
