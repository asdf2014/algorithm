package com.yore.medium;

import com.yore.base.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jia bing wen
 * @date 2021/5/20 15:04
 * @description
 */
public class Number117 {

    public Node connect(Node root) {
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
}
