package com.yore.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yore
 * @date 2022/1/19 9:46
 * @description
 */
public class Number219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indexMap.containsKey(nums[i]) && Math.abs(indexMap.get(nums[i]) - i) <= k) {
                return true;
            }
            indexMap.put(nums[i], i);
        }
        return false;
    }
}
