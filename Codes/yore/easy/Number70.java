package com.yore.easy;

/**
 * @author jia bing wen
 * @date 2021/6/15 8:27
 * @description
 */
public class Number70 {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int res;
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            res = first + second;
            first = second;
            second = res;
        }
        return second;
    }
}
