package com.yore.offer2;

import java.util.*;

/**
 * @author Yore
 * @date 2022/3/18 8:28
 * @description
 */
public class Offer106 {
    public boolean isBipartite(int[][] graph) {
        List<Integer> list = new ArrayList<>();
        int n = graph.length;
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        UnionSet unionSet = new UnionSet(list);
        for (int i = 0; i < n; i++) {
            if (graph[i].length == 0) {
                unionSet.sizeMap.remove(unionSet.nodes.get(i));
                continue;
            }
            for (int j = 0; j < graph[i].length; j++) {
                if (unionSet.isSameSet(i, graph[i][j])) {
                    return false;
                }
                if (j > 0) {
                    unionSet.union(graph[i][j - 1], graph[i][j]);
                }
            }
        }
        return true;
    }

    class Node {
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

    class UnionSet {
        Map<Integer, Node> nodes;
        Map<Node, Node> parents;
        Map<Node, Integer> sizeMap;

        public UnionSet(List<Integer> list) {
            this.nodes = new HashMap<>();
            this.parents = new HashMap<>();
            this.sizeMap = new HashMap<>();
            for (int val : list) {
                Node node = new Node(val);
                nodes.put(val, node);
                parents.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        public Node findFather(Node node) {
            Deque<Node> queue = new LinkedList<>();
            while (node != parents.get(node)) {
                queue.offerLast(node);
                node = parents.get(node);
            }
            while (!queue.isEmpty()) {
                parents.put(queue.pollLast(), node);
            }
            return node;
        }

        public boolean isSameSet(int v1, int v2) {
            if (!nodes.containsKey(v1) || !nodes.containsKey(v2)) {
                return false;
            }
            return findFather(nodes.get(v1)) == findFather(nodes.get(v2));
        }

        public void union(int v1, int v2) {
            if (!nodes.containsKey(v1) || !nodes.containsKey(v2)) {
                return;
            }
            Node n1 = nodes.get(v1);
            Node n2 = nodes.get(v2);
            Node p1 = findFather(n1);
            Node p2 = findFather(n2);
            if (p1 != p2) {
                int size1 = sizeMap.get(p1);
                int size2 = sizeMap.get(p2);
                Node bigNode = size1 > size2 ? p1 : p2;
                Node smallNode = bigNode == p1 ? p2 : p1;
                parents.put(smallNode, bigNode);
                sizeMap.put(bigNode, size1 + size2);
                sizeMap.remove(smallNode);
            }
        }
    }
}
