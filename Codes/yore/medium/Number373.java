package com.yore.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Yore
 * @date 2022/1/14 16:29
 * @description
 */
public class Number373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(k, (o1, o2) -> {
            return nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]];
        });
        List<List<Integer>> res = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;
        for (int i = 0; i < Math.min(m, k); i++) {
            queue.offer(new int[]{i, 0});
        }
        while (k-- > 0 && !queue.isEmpty()) {
            int[] index = queue.poll();
            List<Integer> tmp = new ArrayList<>();
            tmp.add(nums1[index[0]]);
            tmp.add(nums2[index[1]]);
            res.add(tmp);
            if (index[1] + 1 < n) {
                queue.offer(new int[]{index[0], index[1] + 1});
            }
        }
        return res;
    }
}
