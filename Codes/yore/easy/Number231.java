package com.yore.easy;

/**
 * @author jia bing wen
 * @date 2021/5/31 8:10
 * @description
 */
public class Number231 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
