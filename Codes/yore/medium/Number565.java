package com.yore.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Yore
 * @date 2022/7/17 9:07
 * @description
 */
public class Number565 {
    public int arrayNesting(int[] nums) {
        int res = 1;
        Set<Integer> visit = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (visit.contains(i)) {
                continue;
            }
            int j = i;
            int cnt = 0;
            while (!visit.contains(j)) {
                cnt++;
                visit.add(j);
                j = nums[j];
            }
            res = Math.max(res, cnt);
        }
        return res;
    }
}
