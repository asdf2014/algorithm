package com.yore.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jia bing wen
 * @date 2021/6/25 14:49
 * @description
 */
public class Number50 {
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


    /**
     * 快速幂 + 递归
     */

    Map<Integer, Double> memory = new HashMap<>();

    public double myPow1(double x, int n) {
        return n >= 0 ? process(x, n) : 1.0 / process(x, -n);
    }

    public double process(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (memory.containsKey(n)) {
            return memory.get(n);
        }
        double y = process(x, n / 2);
        double res = n % 2 == 0 ? y * y : y * y * x;
        memory.put(n, res);
        return res;
    }

    /**
     * 快速幂加迭代
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow2(double x, int n) {
        return n >= 0 ? process1(x, n) : 1.0 / process1(x, -n);
    }

    public double process1(double x, int n) {
        double ans = 1.0;
        double contribute = x;
        while (n > 0) {
            int t = n % 2;
            if (t == 1) {
                ans *= contribute;
            }
            contribute *= contribute;
            n /= 2;
        }
        return ans;
    }
}
