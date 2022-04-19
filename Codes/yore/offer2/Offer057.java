package com.yore.offer2;

import java.util.TreeSet;

/**
 * @author Yore
 * @date 2022/3/4 9:02
 * @description
 */
public class Offer057 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < nums.length; i++) {
            Long ceil = set.ceiling((long) nums[i] - (long) t);
            if (ceil != null && ceil <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}
