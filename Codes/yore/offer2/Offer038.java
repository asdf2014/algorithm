package com.yore.offer2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yore
 * @date 2022/3/1 8:52
 * @description
 */
public class Offer038 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] waitDays = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peekLast()] < temperatures[i]) {
                int index = stack.pollLast();
                waitDays[index] = i - index;
            }
            stack.offerLast(i);
        }
        return waitDays;
    }
}
