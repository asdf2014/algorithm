package com.yore.offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.DelayQueue;

/**
 * @author jia bing wen
 * @date 2021/7/5 14:21
 * @description
 */
public class Offer59_2 {


    class MaxQueue {
        private Deque<Integer> queue;
        private Deque<Integer> max;

        public MaxQueue() {
            this.queue = new LinkedList<>();
            this.max = new LinkedList<>();
        }

        public int max_value() {
            if (!max.isEmpty()) {
                return max.peek();
            } else {
                return -1;
            }
        }

        public void push_back(int value) {
            queue.offerLast(value);
            while (!max.isEmpty() && max.peekLast() < value) {
                max.pollLast();
            }
            max.offerLast(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            int value = queue.pollFirst();
            if (!max.isEmpty() && max.peekFirst() == value) {
                max.pollFirst();
            }
            return value;
        }
    }
}
