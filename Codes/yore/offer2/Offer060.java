package com.yore.offer2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Yore
 * @date 2022/3/4 10:05
 * @description
 */
public class Offer060 {
    class Unit {
        int value;
        int freq;

        public Unit(int val, int freq) {
            this.value = val;
            this.freq = freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Unit> queue = new PriorityQueue<Unit>(
                new Comparator<Unit>() {
                    @Override
                    public int compare(Unit u1, Unit u2) {
                        return u1.freq - u2.freq;
                    }
                }
        );
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            queue.add(new Unit(entry.getKey(), entry.getValue()));
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll().value;
        }
        return res;
    }
}
