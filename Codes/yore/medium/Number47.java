package com.yore.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/6/2 14:02
 * @description
 */
public class Number47 {
    List<List<Integer>> res = new ArrayList<>();
    int[] visit;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        visit = new int[nums.length];
        backTrack(nums, new LinkedList<Integer>());
        return res;
    }

    public void backTrack(int[] nums, LinkedList<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visit[i] == 1 || (i > 0 && nums[i] == nums[i - 1] && visit[i - 1] == 1)) {
                continue;
            }
            list.add(nums[i]);
            visit[i] = 1;
            backTrack(nums, list);
            visit[i] = 0;
            list.removeLast();
        }
    }

}
