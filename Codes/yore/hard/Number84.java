package com.yore.hard;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yore
 * @date 2022/3/5 9:40
 * @description
 */
public class Number84 {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        Deque<Integer> q = new LinkedList<>();
        q.offerLast(-1);
        for (int i = 0; i < n; i++) {
            while (q.peekLast() != -1 && heights[i] < heights[q.peekLast()]) {
                int h = q.pollLast();
                int j = q.peekLast();
                maxArea = Math.max(maxArea, heights[h] * (i - j - 1));
            }
            q.offerLast(i);
        }
        while (q.peekLast() != -1) {
            int h = q.pollLast();
            int j = q.peekLast();
            maxArea = Math.max(maxArea, heights[h] * (n - j - 1));
        }
        return maxArea;
    }
}
