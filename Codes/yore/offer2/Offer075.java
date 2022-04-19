package com.yore.offer2;

import java.util.*;

/**
 * @author Yore
 * @date 2022/3/11 9:33
 * @description
 */
public class Offer075 {
    public static void main(String[] args) {
        int[] arr2 = new int[2];
        Set<Integer> set = new HashSet<>();
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for (int a : arr2) {
            set.add(a);
        }
        List<Integer> list = new ArrayList();
        int[] idx = new int[1001];
        for (int arr : arr1) {
            idx[arr]++;
            if (!set.contains(arr)) {
                list.add(arr);
            }
        }
        List<Integer> l2 = new ArrayList<>();
        for (int arr : arr2) {
            while (idx[arr] > 0) {
                l2.add(arr);
                idx[arr]--;
            }
        }
        Collections.sort(list);
        l2.addAll(list);
        return l2.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            idxMap.put(arr2[i], i);
        }
        Integer[] nums = Arrays.stream(arr1).boxed().toArray(Integer[]::new);
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (idxMap.containsKey(a)) {
                    return idxMap.containsKey(b) ? idxMap.get(a) - idxMap.get(b) : -1;
                } else {
                    return idxMap.containsKey(b) ? 1 : a - b;
                }
            }
        });
        return Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
    }
}
