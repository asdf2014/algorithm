package com.yore.offer2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yore
 * @date 2022/2/22 15:51
 * @description
 */
public class Offer042 {
    class RecentCounter {
        Deque<Integer> queue;

        public RecentCounter() {
            queue = new LinkedList<>();
        }

        public int ping(int t) {
            queue.offerLast(t);
            while (queue.peekFirst() < (t - 3000)) {
                queue.pollFirst();
            }
            return queue.size();
        }
    }
}
