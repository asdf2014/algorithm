package com.yore.offer;

/**
 * @author jia bing wen
 * @date 2021/6/25 15:25
 * @description
 */
public class Offer64 {
    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
