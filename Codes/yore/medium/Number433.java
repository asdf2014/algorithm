package com.yore.medium;

import java.util.*;

/**
 * @author Yore
 * @date 2022/5/7 9:29
 * @description
 */
public class Number433 {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> visits = new HashSet<>();
        char[] keys = {'A', 'C', 'G', 'T'};
        Set<String> cnt = new HashSet<>(Arrays.asList(bank));
        if (start.equals(end)) {
            return 0;
        }
        if (!cnt.contains(end)) {
            return -1;
        }
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        visits.add(start);
        int step = 1;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                String curr = queue.poll();
                for (int j = 0; j < 8; j++) {
                    for (char ch : keys) {
                        if (curr.charAt(j) != ch) {
                            StringBuilder sb = new StringBuilder(curr);
                            sb.setCharAt(j, ch);
                            String next = sb.toString();
                            if (cnt.contains(next) && !visits.contains(next)) {
                                if (next.equals(end)) {
                                    return step;
                                }
                                queue.offer(next);
                                visits.add(next);
                            }
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
