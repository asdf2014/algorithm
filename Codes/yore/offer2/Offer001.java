package com.yore.offer2;

/**
 * @author Yore
 * @date 2021/11/8 16:35
 * @description
 */
public class Offer001 {
    public static void main(String[] args) {
        System.out.println(divide(-2147483648, 1));
    }

    public static int divide(int a, int b) {
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        if (a > 0) {
            a = -a;
        }
        if (b > 0) {
            b = -b;
        }
        int res = 0;
        while (a <= b) {
            a -= b;
            res++;
        }
        return sign == 1 ? res : -res;

    }
}
