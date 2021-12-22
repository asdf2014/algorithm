package com.yore.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jia bing wen
 * @date 2021/6/5 10:55
 * @description
 */
public class Number268 {
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i <= nums.length; i++) {
            if(!set.contains(i)){
                return i;
            }
        }
        return -1;
    }
}
