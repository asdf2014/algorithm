package com.yore.medium;

import java.util.Arrays;

/**
 * @author jia bing wen
 * @date 2021/5/9 8:28
 * @description
 */
public class Number1482 {

    public static void main(String[] args) {
//        System.out.println(minDays(new int[]{10000, 10000}, 1, 1));
//        System.out.println(minDays(new int[]{1,10,2,9,3,8,4,7,5,6}, 4, 2));
    }

    public static int minDays_ttl(int[] bloomDay, int m, int k) {
        int[] a = new int[bloomDay.length];
        System.arraycopy(bloomDay, 0, a, 0, bloomDay.length);
        Arrays.sort(a);
        int baseDay = a[0];
        int maxDay = a[bloomDay.length - 1];
        if (m * k > bloomDay.length) {
            return -1;
        }
        for (int i = 0; i < bloomDay.length; i++) {
            bloomDay[i] -= baseDay;
        }
        int tmp;
        int count = 0;
        while (baseDay <= maxDay) {
            count = 0;
            tmp = 0;
            for (int i = 0; i < bloomDay.length; i++) {
                tmp = 0;
                while (i < bloomDay.length && bloomDay[i] == 0) {
                    tmp++;
                    if (tmp == k) {
                        count++;
                        break;
                    }
                    i++;
                }
                if (count == m) {
                    return baseDay;
                }
            }
            baseDay++;
            for (int i = 0; i < bloomDay.length; i++) {
                if (bloomDay[i] != 0) {
                    bloomDay[i] -= 1;
                }
            }
        }
        return -1;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int[] a = new int[bloomDay.length];
        System.arraycopy(bloomDay, 0, a, 0, bloomDay.length);
        Arrays.sort(a);
        if (k * m > bloomDay.length) {
            return -1;
        }
        int low = a[0], high = a[bloomDay.length - 1];
        while (low < high) {
            int days = (high - low) / 2 + low;
            if (canMake(bloomDay, days, m, k)) {
                high = days;
            } else {
                low = days + 1;
            }
        }
        return low;
    }

    public boolean canMake(int[] bloomDay, int days, int m, int k) {
        int bouquets = 0;
        int flowers = 0;
        int length = bloomDay.length;
        for (int i = 0; i < length && bouquets < m; i++) {
            if (bloomDay[i] <= days) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        return bouquets >= m;
    }

}
