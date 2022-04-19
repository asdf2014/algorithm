package com.yore.easy;

/**
 * @author Yore
 * @date 2022/1/22 11:02
 * @description
 */
public class Number1137 {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int t1 = 0;
        int t2 = 1;
        int t3 = 1;
        int tmp1, tmp2;
        for (int i = 3; i <= n; i++) {
            tmp1 = t2;
            tmp2 = t3;
            t3 = t1 + t2 + t3;
            t2 = tmp2;
            t1 = tmp1;
        }
        return t3;
    }
}
