package com.yore.offer;

/**
 * @author jia bing wen
 * @date 2021/6/27 16:15
 * @description
 */
public class Offer56_1 {
    public int[] singleNumbers(int[] nums) {
        int xor = 0;
        for (int n : nums) {
            xor ^= n;
        }
        int bit = 1;
        while ((xor & bit) == 0) {
            bit <<= 1;
        }
        int a = 0, b = 0;
        for (int n : nums) {
            if ((bit & n) == 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }
}
