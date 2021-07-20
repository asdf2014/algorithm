package com.yore.offer;

import java.util.Arrays;

/**
 * @author jia bing wen
 * @date 2021/7/5 9:48
 * @description
 */
public class Offer60 {
    private int number;

    public double[] dicesProbability(int n) {
        int max = n * 6;
        int min = n;
        double total = Math.pow(6, n);

        double[] result = new double[max - min + 1];
        result[0] = 1.0 / total;
        int index = 1;
        for (int i = min + 1; i <= max; i++) {
            number = 0;
            count(i, 0, n);
            result[index++] = number / total;
        }
        return result;
    }


    public void count(int target, int sum, int n) {
        if (n == 0) {
            if (target == sum) {
                number++;
            }
            return;
        }
        for (int i = 1; i <= 6; i++) {
            sum += i;
            n--;
            if (sum > target) {
                break;
            }
            count(target, sum, n);
            sum -= i;
            n++;
        }
    }


    public static void main(String[] args) {
        Offer60 o = new Offer60();
        System.out.println(o.dicesProbability(1));
    }


    public double[] dicesProbability1(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }



}
