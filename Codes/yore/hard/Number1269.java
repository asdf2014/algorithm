package com.yore.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author jia bing wen
 * @date 2021/5/13 8:07
 * @description
 */
public class Number1269 {
    int end;
    int count = 0;
    int mod = (int) (Math.pow(10, 9) + 7);

    /**
     * 递归解法，超出时间限制
     *
     * @param steps
     * @param arrLen
     * @return
     */
    public int numWays(int steps, int arrLen) {
        end = arrLen - 1;
        step(0, steps);
        return count % mod;
    }

    public void step(int currentIndex, int step) {
        if (currentIndex == 0 && step == 0) {
            count += 1;
        }
        if (step < 0 || currentIndex < 0 || currentIndex > end) {
            return;
        }
        if (currentIndex > step) {
            return;
        }

        step(currentIndex - 1, step - 1);
        step(currentIndex, step - 1);
        step(currentIndex + 1, step - 1);
    }

    public static void main(String[] args) {
        Number1269 test = new Number1269();
        System.out.println(test.numWays(27, 7));
    }


    /**
     * 动态规划
     *
     * @param steps
     * @param arrLen
     * @return
     */
    public int numWays2(int steps, int arrLen) {
        int mod = (int) (Math.pow(10, 9) + 7);
        int col = Math.min(arrLen - 1, steps);
        int[][] dp = new int[steps + 1][col + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j <= col; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - 1 >= 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % mod;
                }
                if (j + 1 <= col) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % mod;
                }
            }
        }
        return dp[steps][0];
    }
}
