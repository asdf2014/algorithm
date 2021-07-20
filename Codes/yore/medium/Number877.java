package com.yore.medium;

/**
 * @author jia bing wen
 * @date 2021/6/16 9:52
 * @description
 */
public class Number877 {
    public boolean stoneGame(int[] piles) {
        int i = 0;
        int j = piles.length - 1;

        int alex = 0;
        int li = 0;

        while (i <= j) {
            if (piles[i] >= piles[j]) {
                alex += piles[i];
                i++;
            } else {
                alex += piles[j];
                j--;
            }
            if (piles[i] >= piles[j]) {
                li += piles[i];
                i++;
            } else {
                li += piles[j];
                j--;
            }
        }
        return alex > li;
    }
}
