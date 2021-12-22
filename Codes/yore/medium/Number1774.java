package com.yore.medium;

/**
 * @author jia bing wen
 * @date 2021/6/1 8:29
 * @description
 */
public class Number1774 {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        boolean[] answer = new boolean[queries.length];
        long[] sum = new long[candiesCount.length];
        sum[0] = candiesCount[0];
        for (int i = 1; i < candiesCount.length; i++) {
            sum[i] = sum[i - 1] + candiesCount[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int favoriteType = query[0];
            int favoriteDay = query[1];
            int dailyCap = query[2];

            long x1 = favoriteDay + 1;
            long y1 = (long)(favoriteDay + 1) * dailyCap;

            long x2 = favoriteType == 0 ? 1 : sum[favoriteType - 1] + 1;
            long y2 = sum[favoriteType];

            answer[i] = !(x1 > y2 || y1 < x2);
        }
        return answer;
    }
}
