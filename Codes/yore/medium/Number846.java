package com.yore.medium;

import java.util.Arrays;

/**
 * @author Yore
 * @date 2022/1/13 14:37
 * @description
 */
public class Number846 {
    public static void main(String[] args) {
        Number846 n = new Number846();
        n.isNStraightHand(new int[]{1, 2, 3, 6, 3, 2, 4, 7, 8}, 3);
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        if (groupSize == 1) {
            return true;
        }
        Arrays.sort(hand);
        int[] flag = new int[hand.length];
        int left = 0;
        flag[0] = 1;
        int right = 1;
        int count = 1;
        int cur = hand[left];
        while (right < hand.length) {
            if (flag[right] == 0 && hand[right] == cur + 1) {
                flag[right] = 1;
                count++;
                right++;
                cur++;
            } else {
                right++;
            }
            if (count == groupSize) {
                while (left < hand.length && flag[left] != 0) {
                    left++;
                }
                if (left < hand.length) {
                    flag[left] = 1;
                    right = left + 1;
                    count = 1;
                    cur = hand[left];
                } else {
                    break;
                }
            }
        }
        return left == right;
    }
}
