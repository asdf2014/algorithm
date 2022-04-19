package com.yore.medium;

/**
 * @author Yore
 * @date 2022/3/10 9:48
 * @description
 */
public class Number343 {
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int q = n / 3;
        int r = n % 3;
        if (r == 0) {
            return (int) Math.pow(3, q);
        } else if (r == 1) {
            return (int) Math.pow(3, q - 1) * 4;
        }
        return (int) Math.pow(3, q) * 2;
    }
}
