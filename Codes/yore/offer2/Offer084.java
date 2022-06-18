package com.yore.offer2;

import java.util.*;

/**
 * @author Yore
 * @date 2022/1/17 12:49
 * @description
 */
public class Offer084 {
    public List<List<Integer>> res = new ArrayList<>();
    public Map<String, Integer> memory = new HashMap<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        process(nums, 0);
        return res;
    }

    public void process(int[] nums, int idx) {
        if (idx == nums.length) {
            List<Integer> list = new ArrayList<>();
            StringBuilder sb = new StringBuilder("");
            for (int n : nums) {
                list.add(n);
                sb.append(n);
            }
            if (!memory.containsKey(sb.toString())) {
                res.add(list);
                memory.put(sb.toString(), 1);
            }
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            swap(nums, i, idx);
            process(nums, idx + 1);
            swap(nums, i, idx);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
