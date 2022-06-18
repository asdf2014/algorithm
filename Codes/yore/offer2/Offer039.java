package com.yore.offer2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yore
 * @date 2022/3/1 9:37
 * @description
 */
public class Offer039 {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.offerLast(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.peekLast() != -1 && heights[i] < heights[stack.peekLast()]) {
                int h = stack.pollLast();
                int j = stack.peekLast();
                maxArea = Math.max(maxArea, heights[h] * (i - j - 1));
            }
            stack.offerLast(i);
        }
        while (stack.peekLast() != -1) {
            int h = stack.pollLast();
            int j = stack.peekLast();
            maxArea = Math.max(maxArea, heights[h] * (heights.length - j - 1));
        }
        return maxArea;
    }
}
