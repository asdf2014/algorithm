package com.yore.medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yore
 * @date 2022/7/13 9:00
 * @description
 */
public class Number735 {

    public static void main(String[] args) {
        Number735 number735 = new Number735();
        number735.asteroidCollision(new int[]{1, -2, -2, -2});
    }

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> deque = new LinkedList<>();
        deque.offerLast(asteroids[0]);
        for (int i = 1; i < asteroids.length; i++) {
            int val = asteroids[i];
            if (val > 0) {
                deque.offerLast(val);
            } else {
                if (deque.isEmpty() || deque.peekLast() < 0) {
                    deque.offerLast(val);
                } else {
                    while (true) {
                        if (deque.peekLast() < 0) {
                            deque.offerLast(val);
                            break;
                        }
                        if (deque.peekLast() > 0 && deque.peekLast() > Math.abs(val)) {
                            break;
                        }
                        if (deque.peekLast() > 0 && deque.peekLast() == Math.abs(val)) {
                            deque.pollLast();
                            break;
                        }
                        deque.pollLast();
                        if (deque.isEmpty()) {
                            deque.offerLast(val);
                            break;
                        }
                    }
                }
            }
        }
        int[] res = new int[deque.size()];
        int idx = 0;
        while (!deque.isEmpty()) {
            res[idx++] = deque.pollFirst();
        }
        return res;
    }
}
