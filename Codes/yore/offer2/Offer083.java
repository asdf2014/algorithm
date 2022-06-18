package com.yore.offer2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/1/17 11:33
 * @description
 */
public class Offer083 {
    public static void main(String[] args) {
        Offer083 o = new Offer083();
        List<List<Integer>>  result= o.permute(new int[]{1,2,3});
        for (List<Integer> l : result) {
            System.out.print("[");
            for (Integer i : l) {
                System.out.print(i + ",");
            }
            System.out.print("]");
            System.out.println();
        }
    }
    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        process(nums, 0);
        return res;
    }
    public void process(int[] nums, int idx) {
        if (idx == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int n : nums) {
                list.add(n);
            }
            res.add(list);
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            swap(nums, i, idx);
            process(nums, idx + 1);
            swap(nums, i, idx);
        }
    }
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
