package main.liuyi.countprimes;

import java.util.HashSet;
import java.util.Set;

public class CountPrimes {
	public static void main(String[] args) {
		System.out.println(new CountPrimes().countPrimes(499979));
	}
	private static Set<Integer> set=new HashSet<>();
	private static int count=0;
	public int countPrimes(int n) {
        int countPrimes=0;
        if(n<=2){
        	return 0;
        }
        countPrimes=1;
        set.add(2);
        for(int i=3;i<n;i=i+2){
        	if(validPrimes(i)){
        		set.add(i);
        		countPrimes++;
        	}
        }
        System.out.println("count"+count);
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
