package com.yore.easy;

/**
 * @author jia bing wen
 * @date 2021/6/15 8:40
 * @description
 */
public class Number338 {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }
}
