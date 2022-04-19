package com.yore.offer2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/3/12 9:52
 * @description
 */
public class Offer079 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List list = new ArrayList<>(result.get(i));
                list.add(num);
                result.add(list);
            }
        }
        return result;
    }
}
