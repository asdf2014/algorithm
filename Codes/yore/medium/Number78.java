package com.yore.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/4/14 10:03
 * @description
 */
public class Number78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int num : nums) {
            int n = res.size();
            for (int j = 0; j < n; j++) {
                List<Integer> list = new ArrayList<>(res.get(j));
                list.add(num);
                res.add(list);
            }
        }
        return res;
    }
}
