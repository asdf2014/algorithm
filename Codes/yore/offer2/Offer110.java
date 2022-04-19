package com.yore.offer2;

import java.util.*;

/**
 * @author Yore
 * @date 2022/3/17 9:54
 * @description
 */
public class Offer110 {
    List<List<Integer>> list = new ArrayList<>();
    Deque<Integer> queue = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        queue.offerLast(0);
        process(graph, 0, graph.length - 1);
        return list;
    }

    public void process(int[][] graph, int x, int n) {
        if (x == n) {
            list.add(new ArrayList<Integer>(queue));
            return;
        }
        for (int node : graph[x]) {
            queue.offerLast(node);
            process(graph, node, n);
            queue.pollLast();
        }
    }
}
