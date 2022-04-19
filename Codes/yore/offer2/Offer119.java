package com.yore.offer2;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Yore
 * @date 2022/3/20 9:03
 * @description
 */
public class Offer119 {
    public static void main(String[] args) {
        Offer119 o = new Offer119();
        System.out.println(o.longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
    public int longestConsecutive(int[] nums) {
        UnionSet unionSet = new UnionSet(nums);
        for(int num : nums){
            if(unionSet.nodes.containsKey(num-1) && !unionSet.isSameSet(num,num-1)){
                unionSet.union(num,num-1);
            }
        }
        int size = 1;
        for (Integer value : unionSet.sizeMap.values()) {
            size = Math.max(size,value);
        }
        return size;
    }

    class Node{
        int value;

        public Node(int value){
            this.value = value;
        }
    }

    class UnionSet{
        Map<Integer,Node> nodes;
        Map<Node,Node> parents;
        Map<Node,Integer> sizeMap;

        public UnionSet(int[] nums){
            this.nodes = new HashMap<>();
            this.parents = new HashMap<>();
            this.sizeMap = new HashMap<>();
            for(int num : nums){
                Node node = new Node(num);
                nodes.put(num,node);
                parents.put(node,node);
                sizeMap.put(node,1);
            }
        }

        public boolean isSameSet(int v1,int v2){
            if(!nodes.containsKey(v1) || !nodes.containsKey(v2)){
                return false;
            }
            return findFather(nodes.get(v1)) == findFather(nodes.get(v2));
        }

        public Node findFather(Node node){
            Deque<Node> queue = new LinkedList<>();
            while(node != parents.get(node)){
                queue.offerLast(node);
                node = parents.get(node);
            }

            while(!queue.isEmpty()){
                parents.put(queue.pollLast(),node);
            }
            return node;
        }

        public void union(int v1,int v2){
            Node p1 = parents.get(nodes.get(v1));
            Node p2 = parents.get(nodes.get(v2));
            if(p1!=p2){
                int aSize = sizeMap.get(p1);
                int bSize = sizeMap.get(p2);
                Node bigNode = aSize >= bSize ? p1 : p2;
                Node smallNode = bigNode == p1 ? p2 : p1;
                parents.put(smallNode,bigNode);
                sizeMap.put(bigNode,aSize+bSize);
                sizeMap.remove(smallNode);
            }
        }
    }
}
