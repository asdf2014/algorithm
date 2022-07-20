package com.yore.medium;

/**
 * @author Yore
 * @date 2022/6/7 8:22
 * @description
 */
public class Number875 {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(pile, max);
        }
        int left = 1;
        int right = max;
        while (left < right) {
            int mid = (left + right) / 2;
            int count = needHour(mid, piles);
            if (count > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int needHour(int speed, int[] piles) {
        int count = 0;
        for (int pile : piles) {
            count += ((pile + speed - 1) / speed);
        }
        return count;
    }
}
