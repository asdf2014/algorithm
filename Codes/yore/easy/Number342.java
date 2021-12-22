package com.yore.easy;

/**
 * @author jia bing wen
 * @date 2021/5/31 8:03
 * @description
 */
public class Number342 {
    public boolean isPowerOfFour(int n) {

        for (int i = 0; i < 16; i++) {
            if (Math.pow(4, i) == n) {
                return true;
            }
        }
        return false;
    }

    public boolean isPowerOfFour1(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }

}
