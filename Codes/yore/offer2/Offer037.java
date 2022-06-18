package com.yore.offer2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yore
 * @date 2022/2/22 16:16
 * @description
 */
public class Offer037 {
    public static void main(String[] args) {
        System.out.println(asteroidCollision(new int[]{1, -1, -2, -2}));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> queue = new LinkedList<>();
        queue.offerLast(asteroids[0]);
        int idx = 1;
        int n = asteroids.length;
        while (idx < n) {
            int w = asteroids[idx];
            if (w > 0) {
                queue.offerLast(w);
            } else if (queue.isEmpty()) {
                queue.offerLast(w);
            } else {
                int v = 0;
                while (!queue.isEmpty() && queue.peekLast() > 0 && queue.peekLast() <= Math.abs(w)) {
                    v = queue.pollLast();
                    if (v == Math.abs(w)) {
                        break;
                    }
                }
                if (v != Math.abs(w) && (queue.isEmpty() || queue.peekLast() < 0)) {
                    queue.offerLast(w);
                }
            }
            idx++;
        }
        int[] res = new int[queue.size()];
        int i = 0;
        while (!queue.isEmpty()) {
            res[i++] = queue.pollFirst();
        }
        return res;
    }
}
