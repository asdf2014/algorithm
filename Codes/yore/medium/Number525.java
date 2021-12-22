package com.yore.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jia bing wen
 * @date 2021/6/3 7:44
 * @description
 */
public class Number525 {
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        map.put(count, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                count--;
            }
            if (map.containsKey(count)) {
                int preIndex = map.get(count);
                maxLength = Math.max(maxLength, i - preIndex);
            } else {
                map.put(count, i);
            }
        }
        return maxLength;
    }
}
