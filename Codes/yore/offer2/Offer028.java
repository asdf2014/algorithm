package com.yore.offer2;

/**
 * @author Yore
 * @date 2022/2/28 16:37
 * @description
 */
public class Offer028 {
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    public Node dfs(Node node) {
        Node cur = node;
        Node last = null;
        while (cur != null) {
            Node next = cur.next;
            if (cur.child != null) {
                Node childLast = dfs(cur.child);

                cur.next = cur.child;
                cur.child.prev = cur;

                if (next != null) {
                    childLast.next = next;
                    next.prev = childLast;
                }
                cur.child = null;
                last = childLast;
            } else {
                last = cur;
            }
            cur = next;
        }
        return last;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}
