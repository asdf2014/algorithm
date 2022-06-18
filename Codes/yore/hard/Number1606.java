package com.yore.hard;

import java.util.*;

/**
 * @author Yore
 * @date 2022/3/30 9:13
 * @description
 */
public class Number1606 {

    public static void main(String[] args) {
        Number1606 number1606 = new Number1606();
        int[] arrival = new int[]{1, 2, 3, 4, 5};
        int[] load = new int[]{5, 2, 3, 3, 3};
        System.out.println(number1606.busiestServers(3, arrival, load));
    }

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            available.add(i);
        }
        PriorityQueue<int[]> busy = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        int[] requests = new int[k];
        for (int i = 0; i < arrival.length; i++) {
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                available.add(busy.poll()[1]);
            }
            if (available.size() == 0) {
                continue;
            }
            Integer p = available.ceiling(i % k);
            if (p == null) {
                p = available.first();
            }
            requests[p]++;
            busy.offer(new int[]{arrival[i] + load[i], p});
            available.remove(p);
        }
        int max = Arrays.stream(requests).max().getAsInt();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (requests[i] == max) {
                result.add(i);
            }
        }
        return result;
    }
}
