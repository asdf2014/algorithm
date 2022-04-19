package com.yore.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yore
 * @date 2022/1/19 9:39
 * @description
 */
public class Number15 {
    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        if (len <= 2) {
            return res;
        }
        Arrays.sort(nums);
        int sum = 0;
        for (int first = 0; first < nums.length - 2; first++) {
            if (nums[first] > 0) {
                return res;
            }
            //针对负数可能会有问题
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int second = first + 1;
            int third = nums.length - 1;
            while (second < third) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    second++;
                    continue;
                }
                if (third < nums.length - 1 && nums[third] == nums[third + 1]) {
                    third--;
                    continue;
                }
                sum = nums[first] + nums[second] + nums[third];
                if (sum > 0) {
                    third--;
                } else if (sum < 0) {
                    second++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    res.add(list);
                    second++;
                }
            }
        }
        return res;
    }
}
