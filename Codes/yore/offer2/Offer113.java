package com.yore.offer2;

import java.util.*;

/**
 * @author Yore
 * @date 2022/3/18 9:32
 * @description
 */
public class Offer113 {
    public static void main(String[] args) {
        Offer113 o = new Offer113();
        System.out.println(Arrays.toString(o.findOrder(3, new int[][]{{1, 0}, {1, 2}, {0, 1}})));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 1) {
            return new int[]{0};
        }
        List<Integer> result = new ArrayList<>();
        Graph gp = buildGraph(prerequisites, numCourses);
        Map<Node, Integer> inMap = new HashMap<>();
        Deque<Node> zeroQueue = new LinkedList<>();
        for (Node node : gp.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroQueue.offerLast(node);
            }
        }
        Set<Integer> visit = new HashSet<>();
        while (!zeroQueue.isEmpty()) {
            Node cur = zeroQueue.pollFirst();
            visit.add(cur.val);
            result.add(cur.val);
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroQueue.offerLast(next);
                }
            }
        }
        if (visit.size() != inMap.size()) {
            return new int[]{};
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    public Graph buildGraph(int[][] prerequisites, int n) {
        Graph gp = new Graph();
        for (int i = 0; i < n; i++) {
            gp.nodes.put(i, new Node(i));
        }
        for (int[] course : prerequisites) {
            Node from = gp.nodes.get(course[1]);
            Node to = gp.nodes.get(course[0]);
            from.nexts.add(to);
            from.out += 1;
            to.in += 1;
        }
        return gp;
    }


    class Node {
        int val;
        int in;
        int out;
        List<Node> nexts;
        List<Edge> edges;

        public Node(int val) {
            this.val = val;
            this.in = 0;
            this.out = 0;
            this.nexts = new ArrayList<>();
            this.edges = new ArrayList<>();
        }
    }

    class Edge {
        int weight;
        Node from;
        Node to;

        public Edge(int weight, Node from, Node to) {
            this.weight = weight;
            this.from = from;
            this.to = to;
        }
    }

    class Graph {
        Map<Integer, Node> nodes;
        Set<Edge> edges;

        public Graph() {
            this.nodes = new HashMap<>();
            this.edges = new HashSet<>();
        }
    }
}
