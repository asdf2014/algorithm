package com.yore.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jia bing wen
 * @date 2021/5/10 9:02
 * @description
 */
public class Number46 {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(nums, track);
        return res;
    }

    public void backTrack(int[] nums, LinkedList<Integer> track) {
        if (nums.length == track.size()) {
            res.add(new LinkedList<Integer>(track));
            return;
        }
        for (int num : nums) {
            if (track.contains(num)) {
                continue;
            }
            track.offer(num);
            backTrack(nums, track);
            track.pollLast();
        }
    }
}
