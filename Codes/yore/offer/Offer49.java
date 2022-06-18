package com.yore.offer;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * @author jia bing wen
 * @date 2021/6/11 10:42
 * @description
 */
public class Offer49 {
    public int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        Set<Long> existSet = new HashSet<>();
        Queue<Long> queue = new PriorityQueue<>();
        existSet.add(1L);
        queue.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long current = queue.poll();
            ugly = (int) current;

            for (int factor : factors) {
                long next = current * factor;
                if (existSet.add(next)) {
                    queue.offer(next);
                }
            }
        }
        return ugly;
    }

    public static void main(String[] args) {
        Offer49 offer49 = new Offer49();
        System.out.println(offer49.nthUglyNumber(1690));
    }

    public int nthUglyNumber1(int n) {
        int[] dp = new int[n + 1];
        int p2 = 1, p3 = 1, p5 = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2;
            int num3 = dp[p3] * 3;
            int num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);

            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }

        return dp[n];
    }
}
