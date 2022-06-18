package com.yore.medium;

/**
 * @author Yore
 * @date 2022/3/23 10:00
 * @description
 */
public class Number1140 {
    public static void main(String[] args) {
        Number1140 num = new Number1140();
        System.out.println(num.stoneGameII(new int[]{2, 7, 9, 4, 4}));
    }

    /**
     * 递归思路：
     *
     * @param piles
     * @return
     */
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }
        return f(piles, 0, 1, n, suffixSum, 0);
    }


    public int f(int[] piles, int idx, int m, int n, int[] suffixSum, int value) {
        if (idx + 2 * m >= n) {
            return value + suffixSum[idx];
        }
        int count = -1;
        for (int x = 1; x <= 2 * m; x++) {
            count = Math.max(count, suffixSum[idx] - suffixSum[idx + x] + s(piles, idx + x, Math.max(m, x), n, suffixSum, value));
        }
        return count + value;
    }

    public int s(int[] piles, int idx, int m, int n, int[] suffixSum, int value) {
        if (idx + 2 * m >= n) {
            return value;
        }
        int count = Integer.MAX_VALUE;
        for (int x = 1; x <= 2 * m; x++) {
            count = Math.min(count, f(piles, idx + x, Math.max(m, x), n, suffixSum, value));
        }
        return count + value;
    }


    /**
     * 递归加记忆化搜索
     *
     * @param piles
     * @return
     */
    public int stoneGameIICache(int[] piles) {
        int n = piles.length;
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }
        int[][] f_record = new int[n][n + 1];
        int[][] s_record = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                f_record[i][j] = -1;
                s_record[i][j] = -1;
            }
        }
        return f(piles, 0, 1, n, suffixSum, 0, f_record, s_record);
    }


    public int f(int[] piles, int idx, int m, int n, int[] suffixSum, int value, int[][] f_record, int[][] s_record) {
        if (f_record[idx][m] != -1) {
            return f_record[idx][m];
        }
        if (idx + 2 * m >= n) {
            f_record[idx][m] = value + suffixSum[idx];
            return f_record[idx][m];
        }
        int count = -1;
        for (int x = 1; x <= 2 * m; x++) {
            count = Math.max(count, suffixSum[idx] - suffixSum[idx + x] + s(piles, idx + x, Math.max(m, x), n, suffixSum, value, f_record, s_record));
        }
        f_record[idx][m] = count + value;
        return f_record[idx][m];
    }

    public int s(int[] piles, int idx, int m, int n, int[] suffixSum, int value, int[][] f_record, int[][] s_record) {
        if (s_record[idx][m] != -1) {
            return s_record[idx][m];
        }
        if (idx + 2 * m >= n) {
            s_record[idx][m] = value;
            return s_record[idx][m];
        }
        int count = Integer.MAX_VALUE;
        for (int x = 1; x <= 2 * m; x++) {
            count = Math.min(count, f(piles, idx + x, Math.max(m, x), n, suffixSum, value, f_record, s_record));
        }
        s_record[idx][m] = count + value;
        return s_record[idx][m];
    }

    /**
     * dp
     *
     * @param piles
     * @return
     */
    public int stoneGameIIDp(int[] piles) {
        int len = piles.length;
        int[][] dp = new int[len + 1][len + 1];
        int sum = 0;
        for (int i = len - 1; i >= 0; i--) {
            sum += piles[i];
            for (int m = 1; m <= len; m++) {
                if (i + 2 * m >= len) {
                    dp[i][m] = sum;
                } else {
                    for (int x = 1; x <= 2 * m; x++) {
                        dp[i][m] = Math.max(dp[i][m], sum - dp[i + x][Math.max(m, x)]);
                    }
                }
            }
        }
        return dp[0][1];
    }
}
