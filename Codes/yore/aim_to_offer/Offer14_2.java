package com.yore.offer;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author jia bing wen
 * @date 2021/6/23 10:15
 * @description
 */
public class Offer14_2 {
    public int cuttingRope(int n) {
        BigInteger[] dp = new BigInteger[n + 1];
        Arrays.fill(dp, BigInteger.valueOf(1));
        for(int i = 3; i < n + 1; i++){
            for(int j = 1; j < i; j++){
                dp[i] = dp[i].max(BigInteger.valueOf(j * (i - j))).max(dp[i - j].multiply(BigInteger.valueOf(j)));
            }
        }
        return dp[n].mod(BigInteger.valueOf(1000000007)).intValue();
    }

    public static void main(String[] args) {
        Offer14_2 o = new Offer14_2();
        System.out.println(o.cuttingRope(100));
    }
}
