package com.yore.medium;


import java.util.HashMap;

/**
 * @author jia bing wen
 * @date 2021/6/25 9:12
 * @description
 */
public class Number138 {
    HashMap<Node, Node> visitedHash = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (this.visitedHash.containsKey(head)) {
            return this.visitedHash.get(head);
        }
        Node node = new Node(head.val, null, null);
        this.visitedHash.put(head, node);
        node.next = this.copyRandomList(head.next);
        node.random = this.copyRandomList(head.random);

        return node;
    }


    static class Node {
        int val;
        Node next;
        Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}
