package com.yore.offer;

/**
 * @author jia bing wen
 * @date 2021/5/28 8:56
 * @description
 */
public class Offer17 {
    public int[] printNumbers(int n) {
        int max = (int) (Math.pow(10, n) - 1);
        int[] result = new int[max];
        for (int i = 1; i <= max; i++) {
            result[i - 1] = i;
        }
        return result;
    }
}
