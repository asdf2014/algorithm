package com.yore.hard;

import java.util.Arrays;

/**
 * @author jia bing wen
 * @date 2021/5/23 14:55
 * @description
 */
public class Number1707 {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int[] res = new int[queries.length];
        Arrays.sort(nums);
        int max;
        for (int i = 0; i < queries.length; i++) {
            max = -1;
            for (int num : nums) {
                if (num <= queries[i][1]) {
                    max = Math.max(num ^ queries[i][0], max);
                } else {
                    break;
                }
            }
            res[i] = max;
        }
        return res;
    }
}
