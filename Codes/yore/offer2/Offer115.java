package com.yore.offer2;

import java.util.*;

/**
 * @author Yore
 * @date 2022/3/21 10:00
 * @description
 */
public class Offer115 {
    public static void main(String[] args) {
        Offer115 o = new Offer115();
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<Integer>() {{
            add(5);
            add(2);
            add(6);
            add(3);
        }});
        list.add(new ArrayList<Integer>() {{
            add(4);
            add(1);
            add(5);
            add(2);
        }});

//        list.add(new ArrayList<Integer>() {{
//            add(2);
//            add(3);
//        }});
        System.out.println(o.sequenceReconstruction(new int[]{4, 1, 4, 2, 6, 3}, list));
    }

    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if (seqs.size() == 0) {
            return false;
        }
        int n = org.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (List<Integer> list : seqs) {
            for (int num : list) {
                if (!map.containsKey(num)) {
                    map.put(num, new HashSet<>());
                }
                set.add(num);
            }
        }
        if (n == 1 && !set.contains(n) || set.size() != n) {
            return false;
        }
        int[] inDegree = new int[n + 1];
        for (List<Integer> list : seqs) {
            for (int i = 1; i < list.size(); i++) {
                if (!map.get(list.get(i - 1)).contains(list.get(i))) {
                    map.get(list.get(i - 1)).add(list.get(i));
                    inDegree[list.get(i)]++;
                }
            }
        }
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.offerLast(i);
            }
        }
        int idx = 0;
        while (!queue.isEmpty()) {
            int seq = queue.pollFirst();
            if (seq != org[idx] || queue.size() > 0) {
                return false;
            }
            idx++;
            if (map.get(seq) == null) {
                continue;
            }
            for (Integer num : map.get(seq)) {
                inDegree[num]--;
                if (inDegree[num] == 0) {
                    queue.offerLast(num);
                }
            }
        }
        return idx == org.length;
    }
}
