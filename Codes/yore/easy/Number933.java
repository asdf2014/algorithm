package com.yore.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yore
 * @date 2022/5/6 8:55
 * @description
 */
public class Number933 {
    class RecentCounter {
        Deque<Integer> queue;

        public RecentCounter() {
            queue = new LinkedList<>();
        }

        public int ping(int t) {
            queue.offerLast(t);
            while (!queue.isEmpty() && queue.peekFirst() < (t - 3000)) {
                queue.pollFirst();
            }
            return queue.size();
        }
    }
}
