package com.yore.offer;

/**
 * @author jia bing wen
 * @date 2021/5/28 9:10
 * @description 约瑟夫环
 */
public class Offer62 {
    public int lastRemaining(int n, int m) {
        int f = 0;
        for (int i = 2; i != n + 1; ++i) {
            f = (m + f) % i;
        }
        return f;
    }
}
