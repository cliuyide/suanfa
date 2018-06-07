package main.zhangliang.countprimes;

public class CountPrimes {

	public static void main(String[] args) {
		System.out.println(new CountPrimes().countPrimes(10));
	}

	public int countPrimes(int n) {
		if (n <= 2)
			return 0;
		int count = 1;
		int m = -1;
		boolean isprime = false;
		for (int i = 3; i < n; i += 2) {
			m = i;
			isprime = true;
			for (int j = 3; j < m; j += 2) {
				if (i % j == 0) {
					isprime = false;
					break;
				} else {
					m = i / j ;
				}
			}
			if (isprime) {
				count++;
			}
		}
		return count;
	}
}
