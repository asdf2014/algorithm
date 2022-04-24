package com.yore.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Yore
 * @date 2022/4/24 9:19
 * @description
 */
public class Number217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
