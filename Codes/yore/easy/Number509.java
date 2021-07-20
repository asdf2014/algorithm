package com.yore.easy;

/**
 * @author jia bing wen
 * @date 2021/5/7 11:02
 * @description
 */
public class Number509 {

    /**
     * 递归解法
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }


    /**
     * 带备忘录的解法
     * 自顶向下
     */
    public int fib1(int n) {
        int[] memory = new int[n + 1];
        return helper(n, memory);
    }

    private int helper(int n, int[] memory) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (memory[n] != 0) {
            return memory[n];
        }
        memory[n] = helper(n - 1, memory) + helper(n - 2, memory);
        return memory[n];
    }


    /**
     * 自底向上
     */
    public int fib2(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 优化空间
     */
    public int fib3(int n) {
        if (n == 0) {
            return 0;
        }
        int preVal = 0;
        int curVal = 1;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = curVal+preVal;
            preVal = curVal;
            curVal = sum;
        }
        return curVal;
    }
}
