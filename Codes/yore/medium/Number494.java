package com.yore.medium;

/**
 * @author jia bing wen
 * @date 2021/5/27 9:34
 * @description
 */
public class Number494 {
    int[] num;
    int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        num = nums;
        rec(0, target, 0);
        return count;
    }

    public void rec(int i, int target, int sum) {
        if (i == num.length && sum == target) {
            count++;
            return;
        }
        if (i >= num.length) {
            return;
        }
        rec(i + 1, target, sum + num[i]);
        rec(i + 1, target, sum - num[i]);
    }
}
