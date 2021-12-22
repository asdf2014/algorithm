package com.yore.medium;

import java.util.Arrays;

/**
 * @author jia bing wen
 * @date 2021/5/7 14:36
 * @description
 */
public class Number322 {
    int[] memory;

    /**
     * 暴力递归解法
     * 状态： 目标金额
     * 选择： 所有硬币的面值
     * 函数的定义： 凑出总金额最少需要的硬币数
     * base cae： amount == 0时，需要0枚硬币，amount < 0时，返回-1
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = coinChange(coins, amount - coin);
            if (subProblem == -1) {
                continue;
            }
            res = Math.min(res, subProblem + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    /**
     * 带备忘录的解法
     * 自顶向下
     */
    public int coinChange1(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        memory = new int[amount + 1];
        Arrays.fill(memory, -2);
        return helper(coins, amount);
    }

    private int helper(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (memory[amount] != -2) {
            return memory[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = helper(coins, amount - coin);
            if (subProblem == -1) {
                continue;
            }
            res = Math.min(res, subProblem + 1);
        }
        memory[amount] = (res == Integer.MAX_VALUE ? -1 : res);
        return memory[amount];
    }

    /**
     * dp数组迭代
     * 自底向上
     */
    public static int coinChange2(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
