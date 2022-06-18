package com.yore.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yore
 * @date 2022/1/17 11:05
 * @description
 */
public class Number40 {
    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        process(candidates, target, 0, new ArrayList<>());
        return res;
    }

    public void process(int[] candidates, int rest, int index, List<Integer> list) {
        if (rest == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int k = index; k < candidates.length; k++) {
            if (candidates[k] > rest) {
                break;
            }
            if (k > index && candidates[k] == candidates[k - 1]) {
                continue;
            }
            list.add(candidates[k]);
            process(candidates, rest - candidates[k], k + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
