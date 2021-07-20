package com.yore.offer;

/**
 * @author jia bing wen
 * @date 2021/6/25 10:03
 * @description
 */
public class Offer16 {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        double result = 1.0;
        long b = n;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                result *= x;
            }
            x *= x;
            b = b >> 1;
        }
        return result;
    }
}
