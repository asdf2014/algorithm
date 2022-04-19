package com.yore.offer2;

import java.util.*;

/**
 * @author Yore
 * @date 2022/3/22 10:07
 * @description
 */
public class Offer109 {
    public int openLock(String[] deadends, String target) {
        if ("0000".equals(target)) {
            return 0;
        }
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (dead.contains("0000")) {
            return -1;
        }
        int step = 0;
        Deque<String> queue = new LinkedList<>();
        queue.offerLast("0000");
        Set<String> seen = new HashSet<>();
        seen.add("0000");

        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String status = queue.pollFirst();
                for (String next : nextStatus(status)) {
                    if (!seen.contains(next) && !dead.contains(next)) {
                        if (next.equals(target)) {
                            return step;
                        }
                        queue.offerLast(next);
                        seen.add(next);
                    }
                }
            }
        }
        return -1;
    }

    public List<String> nextStatus(String status) {
        List<String> res = new ArrayList<>();
        char[] arr = status.toCharArray();
        for (int i = 0; i < 4; i++) {
            char num = arr[i];
            arr[i] = numPre(num);
            res.add(new String(arr));
            arr[i] = numSucc(num);
            res.add(new String(arr));
            arr[i] = num;
        }
        return res;
    }

    public char numPre(char x) {
        return x == '0' ? '9' : (char) (x - 1);
    }

    public char numSucc(char x) {
        return x == '9' ? '0' : (char) (x + 1);
    }
}
