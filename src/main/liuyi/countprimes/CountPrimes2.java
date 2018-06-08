package main.liuyi.countprimes;

public class CountPrimes2 {
    public static void main(String[] args) {
        System.out.println(new CountPrimes2().countPrimes(10));
    }
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        int count = 0;
        boolean[] arrs = new boolean[n];
        arrs[0] = true;
        arrs[1] = true;
        for (int j = 2; 2 * j < n; j++) {
            arrs[2 * j] = true;
        }
        for (int i = 3; i < n; i += 2) {
            if (arrs[i]) {
                continue;
            }
            for (int j = 2; i * j < n; j++) {
                arrs[i * j] = true;
            }
        }
        for (int i = 2; i < arrs.length; i++) {
            if (!arrs[i]) {
                count++;
            }
        }
        return count;
    }
}
