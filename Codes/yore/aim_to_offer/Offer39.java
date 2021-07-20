package com.yore.offer;

/**
 * @author jia bing wen
 * @date 2021/6/1 9:38
 * @description
 */
public class Offer39 {
    public int majorityElement(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int candidate = 0;
        int restHp = 0;
        for (int current : nums) {
            if (restHp == 0) {
                candidate = current;
                restHp = 1;
            } else if (candidate == current) {
                restHp++;
            } else {
                restHp--;
            }
        }
        int count = 0;
        for (int num : nums) {
            if (candidate == num) {
                count++;
            }
        }
        return count > (nums.length >> 2) ? candidate : -1;
    }
}
