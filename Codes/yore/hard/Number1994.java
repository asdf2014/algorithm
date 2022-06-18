package com.yore.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/2/22 9:18
 * @description
 */
public class Number1994 {
    public static void main(String[] args) {
        List<List<Integer>> list = numberOfGoodSubsets(new int[]{1,2,3,4});

        for(List<Integer> l : list){
            System.out.println(l);
        }

    }
    public static List<List<Integer>> numberOfGoodSubsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        for (int num : nums) {
            int size = list.size();
            for (int j = 0; j < size; j++) {
                List<Integer> clone = new ArrayList<>(list.get(j));
                clone.add(num);
                list.add(clone);
            }
        }
        return list;
    }
}
