package com.yore.easy;

/**
 * @author Yore
 * @date 2022/1/25 10:31
 * @description
 */
public class Number1688 {
    public int numberOfMatches(int n) {
        int count = 0;
        while (n != 1) {
            int t = n / 2;
            if (n % 2 != 0) {
                n = t + 1;
            } else {
                n = t;
            }
            count += t;
        }
        return count;
    }
}
