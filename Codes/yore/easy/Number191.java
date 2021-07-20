package com.yore.easy;

/**
 * @author jia bing wen
 * @date 2021/7/15 9:14
 * @description
 */
public class Number191 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
}
