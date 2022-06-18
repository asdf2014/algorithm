package com.yore.offer;

/**
 * @author jia bing wen
 * @date 2021/6/1 9:11
 * @description
 */
public class Offer15 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
}
