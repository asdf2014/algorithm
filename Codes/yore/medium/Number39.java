package com.yore.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/1/17 11:05
 * @description
 */
public class Number39 {
    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int N = candidates.length;
        int[] record = new int[N];
        process(candidates, target, 0, record);
        return res;
    }

    public void process(int[] candidates, int rest, int index, int[] record) {
        if (rest == 0) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < record.length; i++) {
                for (int t = 0; t < record[i]; t++) {
                    list.add(candidates[i]);
                }
            }
            res.add(list);
            return;
        }
        if (index == candidates.length) {
            return;
        }
        for (int j = 0; j * candidates[index] <= rest; j++) {
            record[index] += j;
            process(candidates, rest - j * candidates[index], index + 1, record);
            record[index] -= j;
        }
    }
}
