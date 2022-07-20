package com.yore.medium;

import java.util.PriorityQueue;

/**
 * @author Yore
 * @date 2022/7/16 10:27
 * @description
 */
public class Number215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }
}
