package com.yore.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jia bing wen
 * @date 2021/6/2 7:52
 * @description
 */
public class Number523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int reminder = 0;
        for (int i = 0; i < nums.length; i++) {
            reminder = (reminder + nums[i]) % k;
            if (map.containsKey(reminder)) {
                int preIndex = map.get(reminder);
                if (i - preIndex >= 2) {
                    return true;
                }
            } else {
                map.put(reminder, i);
            }
        }
        return false;
    }
}
