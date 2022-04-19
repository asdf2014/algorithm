package com.yore.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/3/12 10:07
 * @description
 */
public class Number448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int idx = (nums[i] - 1) % n;
            nums[idx] += n;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
