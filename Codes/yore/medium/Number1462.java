package com.yore.medium;

import java.util.*;

/**
 * @author Yore
 * @date 2022/7/19 9:43
 * @description
 */
public class Number1462 {

    public static void main(String[] args) {
        Number1462 number = new Number1462();
        System.out.println(number.checkIfPrerequisite(4, new int[][]{{2, 3}, {2, 1}, {0, 3}, {0, 1}},
                new int[][]{{0, 1}, {0, 3}, {2, 3}, {3, 0}, {2, 0}, {0, 2}}));
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Graph g = buildGraph(prerequisites);
        List<Boolean> res = new ArrayList<>();
        Deque<Node> queue = new LinkedList<>();
        Map<Node,Integer> inMap = new HashMap<>();
        Map<Integer,Set<Integer>> fatherSet = new HashMap<>();

        for(Node node : g.nodes.values()){
            inMap.put(node,node.in);
            if(node.in == 0 ){
                queue.offerLast(node);
                fatherSet.put(node.val,new HashSet());
            }
        }
        while(!queue.isEmpty()){
            Node cur = queue.pollFirst();
            Set<Integer> set = fatherSet.get(cur.val);
            for (Node nxt : cur.next) {
                inMap.put(nxt, inMap.get(nxt) - 1);
                if (!fatherSet.containsKey(nxt.val)) {
                    fatherSet.put(nxt.val, new HashSet<>(set));
                } else {
                    fatherSet.get(nxt.val).addAll(set);
                }
                fatherSet.get(nxt.val).add(cur.val);
                if (inMap.get(nxt) == 0) {
                    queue.offerLast(nxt);
                }
            }
        }
        for(int[] query : queries){
            if(fatherSet.containsKey(query[1]) && fatherSet.get(query[1]).contains(query[0])){
                res.add(true);
            }else{
                res.add(false);
            }
        }
        return res;
    }

    public Graph buildGraph(int[][] prerequisites){
        Graph graph = new Graph();
        for(int[] data : prerequisites){
            int before = data[0];
            int after = data[1];
            Node from;
            Node to;
            if(graph.nodes.containsKey(before)){
                from = graph.nodes.get(before);
            }else{
                from = new Node(before);
                graph.nodes.put(before,from);
            }

            if(graph.nodes.containsKey(after)){
                to = graph.nodes.get(after);
            }else{
                to = new Node(after);
                graph.nodes.put(after,to);
            }
            to.in +=1;
            from.next.add(to);
        }
        return graph;
    }

    class Graph{
        Map<Integer,Node> nodes;

        public Graph(){
            this.nodes = new HashMap<>();
        }
    }

    class Node{
        private int val;
        private int in;
        private List<Node> next;
        public Node(int val){
            this.val = val;
            this.in = 0;
            this.next = new ArrayList<>();
        }
    }
}
