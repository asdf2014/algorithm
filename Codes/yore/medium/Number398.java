package com.yore.medium;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yore
 * @date 2022/4/25 8:43
 * @description
 */
public class Number398 {
    Map<Integer, List<Integer>> indexMap = new HashMap<>();

    public Number398(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = indexMap.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            indexMap.put(nums[i], list);
        }
    }

    public int pick(int target) {
        List<Integer> list = indexMap.get(target);
        int len = list.size();
        int idx = new SecureRandom().nextInt(len);
        return list.get(idx);
    }


    /**
     * 水塘抽样法
     */
    class Solution {
        int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int pick(int target) {
            int ans = 0;
            for (int i = 0, cnt = 0; i < this.nums.length; i++) {
                if (nums[i] == target) {
                    cnt++;
                    if (new SecureRandom().nextInt(cnt) == 0) {
                        ans = i;
                    }
                }
            }
            return ans;
        }
    }
}
