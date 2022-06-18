package com.yore.offer2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yore
 * @date 2022/3/1 10:01
 * @description
 */
public class Offer040 {
    public int maximalRectangle(String[] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int col = matrix[0].length();
        int[] heights = new int[col];
        int maxArea = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char c = matrix[i].charAt(j);
                if (c == '0') {
                    heights[j] = 0;
                } else {
                    heights[j] += c - '0';
                }

            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();
        stack.offerLast(-1);
        int n = heights.length;
        int area = 0;
        for (int i = 0; i < n; i++) {
            while (stack.peekLast() != -1 && heights[i] < heights[stack.peekLast()]) {
                int h = stack.pollLast();
                int j = stack.peekLast();
                area = Math.max(area, heights[h] * (i - j - 1));
            }
            stack.offerLast(i);
        }
        while (stack.peekLast() != -1) {
            int h = stack.pollLast();
            int j = stack.peekLast();
            area = Math.max(area, heights[h] * (n - j - 1));
        }
        return area;
    }
}
