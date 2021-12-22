package com.yore.easy;

/**
 * @author jia bing wen
 * @date 2021/7/15 9:42
 * @description
 */
public class Number172 {
    public int trailingZeroes(int n) {
        int res = 0;
        long divisor = 5;
        while (divisor <= n) {
            res += n / divisor;
            divisor *= 5;
        }
        return res;
    }
}
