package com.yore.easy;

/**
 * @author Yore
 * @date 2022/6/30 9:08
 * @description
 */
public class Number117 {
    int mod = (int) (Math.pow(10, 9) + 7);

    public int numPrimeArrangements(int n) {
        int primeCount = 0;
        for (int i = 2; i <= n; i++) {
            int num = i;
            int j = 2;
            for (; j <= num / 2; j++) {
                if (num % j == 0) {
                    break;
                }
            }
            if (j > num / 2) {
                primeCount++;
            }
        }
        int p = primeCount;
        int q = n - primeCount;
        long res = 1;
        while (p > 0) {
            res = (res * p) % mod;
            p--;
        }
        while (q > 0) {
            res = (res * q) % mod;
            q--;
        }
        return (int) res;
    }
}
