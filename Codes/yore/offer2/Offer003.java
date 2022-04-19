package com.yore.offer2;

/**
 * @author Yore
 * @date 2021/11/8 19:08
 * @description
 */
public class Offer003 {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = Integer.bitCount(i);
        }
        return res;
    }
}
