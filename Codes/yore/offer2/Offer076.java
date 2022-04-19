package com.yore.offer2;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Yore
 * @date 2022/3/11 10:18
 * @description
 */
public class Offer076 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }
}
