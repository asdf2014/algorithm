package com.yore.offer2;

import java.util.*;

/**
 * @author Yore
 * @date 2022/1/17 10:53
 * @description
 */
public class Offer082 {

    public static void main(String[] args) {
        Offer082 o = new Offer082();
        List<List<Integer>> result = o.combinationSum2(new int[]{10, 2, 1, 7, 6, 1, 5}, 8);
        for (List<Integer> l : result) {
            System.out.print("[");
            for (Integer i : l) {
                System.out.print(i + ",");
            }
            System.out.println("]");
            System.out.println();
        }
    }


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
