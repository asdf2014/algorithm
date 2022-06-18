package com.yore.offer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yore
 * @date 2022/1/18 16:16
 * @description
 */
public class Offer007 {

    public static void main(String[] args) {
        Offer007 o = new Offer007();
        System.out.println(o.threeSum(new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6}));
    }

    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        if (len <= 2) {
            return res;
        }
        Arrays.sort(nums);
        int sum = 0;
        for (int first = 0; first < nums.length - 2; first++) {
            if (first == 0 || nums[first] != nums[first - 1]) {
                int second = first + 1;
                int third = nums.length - 1;
                while (second < third) {
                    if ((second == (first + 1) || nums[second] != nums[second - 1])) {
                        if (third == nums.length - 1 || nums[third] != nums[third + 1]) {
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
                        } else {
                            third--;
                        }
                    } else {
                        second++;
                    }
                }
            }
        }
        return res;
    }
}
