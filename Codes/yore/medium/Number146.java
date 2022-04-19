package com.yore.medium;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Yore
 * @date 2021/12/29 11:03
 * @description
 */
public class Number146 {

    class Node {
        private int key;
        private int value;
        private Node next;
        private Node pre;

        public Node(int key, int val) {
            this.key = key;
            this.value = val;
        }
    }

    class LRUCache {
        private LinkedHashMap<Integer, Node> linkMap;
        private int current;
        private int capacity;

        private Node HEAD;
        private Node TAIL;

        public LRUCache(int capacity) {
            this.linkMap = new LinkedHashMap<>(capacity + 2);
            this.current = 0;
            this.capacity = capacity;

            //初始化双向链表头尾节点
            HEAD = new Node(-1, -1);
            TAIL = new Node(10001, -1);
            HEAD.next = TAIL;
            TAIL.pre = HEAD;
            this.linkMap.put(-1, HEAD);
            this.linkMap.put(10001, TAIL);
        }

        public int get(int key) {
            printNode("get " + key);
            if (linkMap.containsKey(key)) {
                Node node = linkMap.get(key);

                //从原位置中删除node
                node.pre.next = node.next;
                node.next.pre = node.pre;
                //添加node到队尾，代表最近访问
                Node first = TAIL.pre;
                TAIL.pre = node;
                node.next = TAIL;
                first.next = node;
                node.pre = first;
                return linkMap.get(key).value;
            }
            return -1;
        }

        public void put(int key, int value) {
            Node node = new Node(key, value);
            if (linkMap.containsKey(key)) {
                linkMap.get(key).value = value;
                node = linkMap.get(key);
                //从原位置中删除node
                removeOriginalNode(node);
                //添加node到队尾，代表最近访问
                addNodeToTail(node);
            } else {
                if (current >= capacity) {
                    // 删除最久元素
                    Node removeNode = HEAD.next;
                    HEAD.next = removeNode.next;
                    removeNode.next.pre = HEAD;

                    linkMap.remove(removeNode.key);
                    this.current--;
                }
                Node first = TAIL.pre;
                TAIL.pre = node;
                node.next = TAIL;
                first.next = node;
                node.pre = first;

                this.linkMap.put(key, node);
                this.current++;
            }
            printNode("put " + key + "后");
        }

        public void removeOriginalNode(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        public void addNodeToTail(Node node) {
            Node first = TAIL.pre;
            TAIL.pre = node;
            node.next = TAIL;
            first.next = node;
            node.pre = first;
        }

        public void printNode(String message) {
            Node it = HEAD;
            System.out.print(message + " 队列: ");
            while (it != null) {
                System.out.print("[" + it.key + "-" + it.value + "] ->");
                it = it.next;
            }
            System.out.print(message + " MAP: ");
            for (Map.Entry<Integer, Node> entry : linkMap.entrySet()) {
                System.out.print("[" + entry.getKey() + "-" + entry.getValue().value + "] ->");
            }
            System.out.println();
        }
    }


}
