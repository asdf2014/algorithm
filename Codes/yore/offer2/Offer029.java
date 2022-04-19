package com.yore.offer2;

/**
 * @author Yore
 * @date 2022/2/22 15:10
 * @description
 */
public class Offer029 {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node t = new Node(insertVal);
            t.next = t;
            return t;
        }
        Node p = head;
        while (p.next != head) {
            if (p.val <= insertVal && p.next.val >= insertVal) {
                break;
            }
            if (p.next.val < p.val) {
                if (p.val <= insertVal || p.next.val >= insertVal) {
                    break;
                }
            }
            p = p.next;
        }
        p.next = new Node(insertVal, p.next);
        return head;
    }

    class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}
