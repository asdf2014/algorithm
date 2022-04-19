package com.yore.offer;

/**
 * @author jia bing wen
 * @date 2021/7/1 19:01
 * @description
 */
public class Offer65 {
    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }
}
