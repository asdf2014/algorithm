package com.yore.medium;

/**
 * @author jia bing wen
 * @date 2021/5/7 21:17
 * @description
 */
public class Number29 {

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        //计算符号
        int sign = (dividend > 0 ? (divisor > 0 ? 1 : -1) : (divisor > 0 ? -1 : 1));
        int a = dividend > 0 ? -dividend : dividend;
        int b = divisor > 0 ? -divisor : divisor;
        int quotient = 0;
        int step = b;
        int q = 1;

        while (a <= b) {
            a -= step;
            quotient += q;
            step += step;
            q += q;
            if (a - step > b) {
                step = b;
                q = 1;
            }
        }
        return sign > 0 ? quotient : -quotient;
    }
}
