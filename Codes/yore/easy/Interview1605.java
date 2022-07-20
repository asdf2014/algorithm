package com.yore.easy;

/**
 * @author Yore
 * @date 2022/6/6 19:05
 * @description
 */
public class Interview1605 {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}
