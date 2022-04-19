package com.yore.offer;

/**
 * @author jia bing wen
 * @date 2021/5/28 8:03
 * @description
 */
public class Offer10_1 {
    int[] memory;

    public int fib(int n) {
        if (n < 1) {
            return 0;
        }
        memory = new int[n + 1];
        return dfs(n);
    }

    public int dfs(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (memory[n] != 0) {
            return memory[n];
        }
        memory[n] = (dfs(n - 1) + dfs(n - 2)) % 1000000007;
        return memory[n];
    }


    public int fib2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int preVal1 = 1;
        int preVal2 = 1;
        int sum;
        for (int i = 3; i < n; i++) {
            sum = preVal1 + preVal2;
            preVal1 = preVal2;
            preVal2 = sum;
        }
        return preVal2;
    }
}
