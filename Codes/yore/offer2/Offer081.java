package com.yore.offer2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/1/17 10:17
 * @description
 */
public class Offer081 {

    public static void main(String[] args) {
        Offer081 o = new Offer081();
        System.out.println(o.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

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
