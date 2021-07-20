package com.yore.offer;

/**
 * @author jia bing wen
 * @date 2021/5/28 15:08
 * @description
 */
public class Offer10_2 {

    public int numWays(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 1 || n == 0) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int preVal = 1;
        int current = 2;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = (preVal + current) % 1000000007;
            preVal = current;
            current = sum;
        }
        return current;
    }
}
