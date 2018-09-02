
package main.liuyi.shoppingoffers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * https://leetcode-cn.com/problems/shopping-offers/description/
 * @author liuyi
 *
 */
public class ShoppingOffers {
	public static void main(String[] args) {
		List<Integer> price=Stream.of(1,1,1).collect(Collectors.toList());
		List<List<Integer>> special=new ArrayList<List<Integer>>();
		special.add(Stream.of(1,1,0,0).collect(Collectors.toList()));
		special.add(Stream.of(2,2,1,9).collect(Collectors.toList()));
		List<Integer> needs=Stream.of(1,1,0).collect(Collectors.toList());
		System.out.println(new ShoppingOffers().shoppingOffers(price, special, needs));
	}
	private int result;
	public int shoppingOffers(List<Integer> price, List<List<Integer>> special,
			List<Integer> needs) {
		if(needs==null||needs.size()==0){
			return result;
		}
		if(special==null||special.size()==0){
			result=getfillPrice(price, needs);
			return result;
		}
		filter(special, needs);
		List<Integer> buySum=new ArrayList<Integer>();
		for(int i=0;i<price.size();i++){
			buySum.add(0);
		}
		result=getfillPrice(price, needs);
		handle(price.size(), 0,buySum, special, needs, price);
		return result;
	}
	
	private void handle(int priceLength,int sumPrice,List<Integer> buySum,List<List<Integer>> special,List<Integer> needs,List<Integer> price){
		for(int i=0;i<special.size();i++){
			List<Integer> specialItem=special.get(i);
			int b = compare(buySum, specialItem, needs);
			if(b==0){
				 sumPrice+=specialItem.get(priceLength);
				 if(sumPrice<result){
					 result=sumPrice;
				 }
				 return;
			}else if(b<0){
				continue;
			}else if(b>0){
				List<Integer> buySumItem=new ArrayList<Integer>();
				for(int a=0;a<priceLength;a++){
					buySumItem.add(buySum.get(a)+specialItem.get(a));
				}
				handle(priceLength, sumPrice+specialItem.get(priceLength),buySumItem, special, needs,price);
			}
		}
		List<Integer> remaining=new ArrayList<Integer>();
		for(int i=0;i<priceLength;i++){
			remaining.add(needs.get(i)-buySum.get(i));
		}
		sumPrice+=getfillPrice(price, remaining);
		if(sumPrice<result){
			 result=sumPrice;
		 }
	}

	private void filter(List<List<Integer>> special, List<Integer> needs) {
		Iterator<List<Integer>> specialIterator = special.iterator();
		while(specialIterator.hasNext()){
			List<Integer> next=specialIterator.next();
			for(int i=0;i<needs.size();i++){
				if(next.get(i)>needs.get(i)){
					specialIterator.remove();
					break;
				}
			}
		}
	}
	
	private int getfillPrice(List<Integer> price,List<Integer> needs){
		int result=0;
		for(int i=0;i<price.size();i++){
			result+=(price.get(i)*needs.get(i));
		}
		return result;
	}
	
	
	private int compare(List<Integer> now,List<Integer> special,List<Integer> needs){
		int result=0;
		for(int i=0;i<now.size();i++){
			if(now.get(i)+special.get(i)>needs.get(i)){
				result=-1;
				break;
			}
			if(now.get(i)+special.get(i)<needs.get(i)){
				result=1;
			}
		}
		return result;
	}
	
}
