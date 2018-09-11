package main.liuyi.distributecandies;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {
	public int distributeCandies(int[] candies) {
		Set<Integer> sis = new HashSet<>();
		for (int i = 0; i < candies.length; i++) {
			if (!sis.contains(candies[i])) {
				sis.add(candies[i]);
			}
		}
		int half = candies.length / 2;
		return sis.size() > half ? half : sis.size();
	}
}
