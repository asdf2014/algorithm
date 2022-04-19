package com.yore.offer2;

import java.util.PriorityQueue;

/**
 * @author Yore
 * @date 2022/3/4 8:33
 * @description
 */
public class Offer059 {
    class KthLargest {
        PriorityQueue<Integer> queue;
        int k;

        public KthLargest(int k, int[] nums) {
            queue = new PriorityQueue<>();
            for (int num : nums) {
                queue.add(num);
            }
            this.k = k;
        }

        public int add(int val) {
            queue.add(val);
            while (queue.size() > this.k) {
                queue.poll();
            }
            return queue.peek();
        }
    }
}
