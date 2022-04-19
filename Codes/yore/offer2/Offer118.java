package com.yore.offer2;

import java.util.*;

/**
 * @author Yore
 * @date 2022/3/19 9:55
 * @description
 */
public class Offer118 {
    public static void main(String[] args) {
        Offer118 o = new Offer118();
        System.out.println(o.findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}}));
    }

    public int[] findRedundantConnection(int[][] edges) {
        int m = edges.length;
        List<int[]> list = new ArrayList<>();
        UnionSet unionSet = new UnionSet(m);
        for (int i = 0; i < m; i++) {
            if (unionSet.isSameSet(edges[i][0], edges[i][1])) {
                list.add(new int[]{edges[i][0], edges[i][1]});
            } else {
                unionSet.union(edges[i][0], edges[i][1]);
            }
        }
        return list.get(list.size() - 1);
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

        public UnionSet(int n) {
            this.nodes = new HashMap<>();
            this.parents = new HashMap<>();
            this.sizeMap = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                Node node = new Node(i);
                nodes.put(i, node);
                parents.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        public boolean isSameSet(int v1, int v2) {
            if (!nodes.containsKey(v1) || !nodes.containsKey(v2)) {
                return false;
            }
            return findFather(nodes.get(v1)) == findFather(nodes.get(v2));
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

        public void union(int v1, int v2) {
            Node p1 = findFather(nodes.get(v1));
            Node p2 = findFather(nodes.get(v2));
            if (p1 != p2) {
                int aSetSize = sizeMap.get(p1);
                int bSetSize = sizeMap.get(p2);
                Node bigNode = aSetSize >= bSetSize ? p1 : p2;
                Node smallNode = bigNode == p1 ? p2 : p1;
                parents.put(smallNode, bigNode);
                sizeMap.put(bigNode, aSetSize + bSetSize);
                sizeMap.remove(smallNode);
            }
        }
    }

}
