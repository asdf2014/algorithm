package com.yore.medium;

/**
 * @author Yore
 * @date 2022/2/24 15:08
 * @description
 */
public class Number1014 {
    public int maxScoreSightseeingPair(int[] values) {
        int max = Integer.MIN_VALUE;
        int len = values.length;
        int mx = values[0];
        for (int i = 1; i < len; i++) {
            max = Math.max(max, mx + values[i] - i);
            mx = Math.max(mx, values[i] + i);
        }
        return max;
    }
}
