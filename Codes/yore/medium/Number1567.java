package com.yore.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/2/23 14:56
 * @description
 */
public class Number1567 {
    public static void main(String[] args) {
        System.out.println(getMaxLen(new int[]{-16,0,-14,4,-13,-17,-19,-17,-21,-11,12}));
    }

    public static int getMaxLen(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len + 1];
        dp[0] = nums[0] > 0 ? 1 : 0;
        int zeroPos = nums[0] == 0 ? 0 : -1;
        List<Integer> idxList = new ArrayList<>();
        if(nums[0]<0){
            idxList.add(0);
        }
        for (int i = 1; i < len; i++) {
            if (nums[i] > 0) {
                dp[i] = dp[i - 1] + 1;
            } else if (nums[i] < 0) {
                int size = idxList.size();
                if (size > 0) {
                    if (size % 2 != 0) {
                        dp[i] = i - zeroPos;
                    } else {
                        dp[i] = i - idxList.get(0);
                    }
                } else {
                    dp[i] = 0;
                }
                idxList.add(i);
            } else {
                dp[i] = 0;
                zeroPos = i;
                idxList = new ArrayList<>();
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
