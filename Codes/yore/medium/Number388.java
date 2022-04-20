package com.yore.medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yore
 * @date 2022/4/20 9:12
 * @description
 */
public class Number388 {
    public int lengthLongestPath(String input) {
        int n = input.length();
        int pos = 0;
        int ans = 0;
        Deque<Integer> queue = new LinkedList<>();
        while (pos < n) {
            int depth = 1;
            while (pos < n && input.charAt(pos) == '\t') {
                pos++;
                depth++;
            }
            boolean isFile = false;
            int len = 0;
            while (pos < n && input.charAt(pos) != '\n') {
                if (input.charAt(pos) == '.') {
                    isFile = true;
                }
                len++;
                pos++;
            }
            pos++;
            while (queue.size() >= depth) {
                queue.pollLast();
            }
            if (!queue.isEmpty()) {
                len += queue.peekLast() + 1;
            }
            if (isFile) {
                ans = Math.max(ans, len);
            } else {
                queue.offerLast(len);
            }
        }
        return ans;
    }
}
