package com.yore.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Yore
 * @date 2022/7/18 10:30
 * @description
 */
public class Number785 {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        UnionSet us = new UnionSet(n);
        for (int i = 0; i < graph.length; i++) {
            int pre = -1;
            for (int j = 0; j < graph[i].length; j++) {
                if (us.isSameSet(i, graph[i][j])) {
                    return false;
                }
                if (pre == -1) {
                    pre = graph[i][j];
                } else {
                    us.union(pre, graph[i][j]);
                }
            }
        }
        return true;
    }

    class UnionSet {
        Map<Integer, Node> nodes;
        Map<Node, Node> parent;
        Map<Node, Integer> sizeMap;

        public UnionSet(int n) {
            this.nodes = new HashMap<>();
            this.parent = new HashMap<>();
            this.sizeMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                Node node = new Node(i);
                nodes.put(i, node);
                parent.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        public Node findFather(Node node) {
            Stack<Node> st = new Stack<>();
            while (node != parent.get(node)) {
                st.push(node);
                node = parent.get(node);
            }
            while (!st.isEmpty()) {
                parent.put(st.pop(), node);
            }
            return node;
        }

        public boolean isSameSet(int a, int b) {
            if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
                return false;
            }
            return findFather(nodes.get(a)) == findFather(nodes.get(b));
        }

        public void union(int a, int b) {
            if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
                return;
            }
            Node aHead = findFather(nodes.get(a));
            Node bHead = findFather(nodes.get(b));
            if (aHead != bHead) {
                int aSize = sizeMap.get(aHead);
                int bSize = sizeMap.get(bHead);
                Node bigNode = aSize > bSize ? aHead : bHead;
                Node smallNode = bigNode == aHead ? bHead : aHead;
                parent.put(smallNode, bigNode);
                sizeMap.put(bigNode, aSize + bSize);
                sizeMap.remove(smallNode);
            }
        }
    }

    class Node {
        int val;

        public Node(int val) {
            this.val = val;
        }
    }
}