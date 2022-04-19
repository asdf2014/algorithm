package com.yore.hard;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yore
 * @date 2022/3/5 9:54
 * @description
 */
public class Number85 {
    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] heights = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = matrix[i][j];
                if (c == '0') {
                    heights[j] = 0;
                } else {
                    heights[j] += c - '0';
                }
            }
            maxArea = Math.max(maxArea, calMaxArea(heights, n));
        }
        return maxArea;
    }

    public int calMaxArea(int[] heights, int n) {
        int area = 0;
        Deque<Integer> q = new LinkedList<>();
        q.offerLast(-1);
        for (int i = 0; i < n; i++) {
            while (q.peekLast() != -1 && heights[i] < heights[q.peekLast()]) {
                int h = q.pollLast();
                int j = q.peekLast();
                area = Math.max(area, heights[h] * (i - j - 1));
            }
            q.offerLast(i);
        }
        while (q.peekLast() != -1) {
            int h = q.pollLast();
            int j = q.peekLast();
            area = Math.max(area, heights[h] * (n - j - 1));
        }
        return area;
    }
}
