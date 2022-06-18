package com.yore.offer2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/3/12 11:04
 * @description
 */
public class Offer080 {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        process(n, k, 1, new ArrayList<>());
        return result;
    }

    public void process(int n, int k, int index, List<Integer> list) {
        if (list.size() == k) {
            List<Integer> l = new ArrayList<>(list);
            result.add(l);
            return;
        }
        if (index > n) {
            return;
        }
        list.add(index);
        process(n, k, index + 1, list);
        list.remove(list.size() - 1);
        process(n, k, index + 1, list);
    }
}
