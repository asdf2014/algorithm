package com.yore.offer2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Yore
 * @date 2022/3/4 10:54
 * @description
 */
public class Offer061 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o2.get(0) + o2.get(1) - o1.get(0) - o1.get(0);
            }
        });
        int l1 = Math.min(nums1.length, k);
        int l2 = Math.min(nums2.length, k);
        for (int i = 0; i < l1; i++) {
            for (int j = 1; j < l2; j++) {
                List<Integer> list = new ArrayList<>();
                list.add(nums1[i]);
                list.add(nums2[j]);
                queue.add(list);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }
        while (!queue.isEmpty()) {
            res.add(queue.poll());
        }
        return res;
    }
}
