package com.yore.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yore
 * @date 2022/1/19 10:05
 * @description
 */
public class Number18 {

    public static void main(String[] args) {
        Number18 n = new Number18();
        System.out.println(n.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }

    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        if (len <= 3) {
            return res;
        }
        Arrays.sort(nums);
        int sum = 0;
        for (int first = 0; first < len - 3; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            for (int second = first + 1; second < len - 2; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                int third = second + 1;
                int forth = len - 1;
                while (third < forth) {
                    if (third > second + 1 && nums[third] == nums[third - 1]) {
                        third++;
                        continue;
                    }
                    if (forth < len - 1 && nums[forth] == nums[forth + 1]) {
                        forth--;
                        continue;
                    }
                    sum = nums[first] + nums[second] + nums[third] + nums[forth];
                    if (sum > target) {
                        forth--;
                    } else if (sum < target) {
                        third++;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        list.add(nums[forth]);
                        res.add(list);
                        third++;
                    }
                }
            }
        }
        return res;
    }
}
