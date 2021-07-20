package com.yore.medium;

import com.yore.base.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jia bing wen
 * @date 2021/5/17 9:40
 * @description
 */
public class Number116 {
    /**
     * 广度优先
     *
     * @param root
     * @return
     */
    public Node connect1(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            count--;
            if (count == 0) {
                count = queue.size();
                int flag = 0;
                Node preNode = null;
                for (Node tmp : queue) {
                    if (flag == 0) {
                        preNode = tmp;
                        flag = 1;
                    } else {
                        preNode.next = tmp;
                        preNode = tmp;
                    }
                }
            }
        }
        return root;
    }

    /**
     * 递归
     */
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        connectTwoNode(root.left, root.right);
        return root;
    }

    public void connectTwoNode(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        node1.next = node2;
        connectTwoNode(node1.left, node1.right);
        connectTwoNode(node2.left, node2.right);
        connectTwoNode(node1.right, node2.left);
    }


}
