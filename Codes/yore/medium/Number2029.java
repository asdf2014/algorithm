package com.yore.medium;

/**
 * @author Yore
 * @date 2022/1/20 11:07
 * @description
 */
public class Number2029 {
    public boolean stoneGameIX(int[] stones) {
        int[] count = new int[3];
        for (int v : stones) {
            count[v % 3]++;
        }
        return count[0] % 2 == 0 ? !(count[1] == 0 || count[2] == 0) : Math.abs(count[1] - count[2]) > 2;
    }
}
