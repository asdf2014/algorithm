package com.yore.offer;

import com.yore.base.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jia bing wen
 * @date 2021/7/14 8:21
 * @description
 */
public class Offer36 {

    private List<Node> nodeList;

    public Node treeToDoublyList1(Node root) {
        if (root == null) {
            return null;
        }
        nodeList = new ArrayList<>();
        inOrder(root);
        Node first = nodeList.get(0);
        if (nodeList.size() == 1) {
            first.left = first;
            first.right = first;
            return first;
        }
        for (int i = 1; i < nodeList.size() - 1; i++) {
            nodeList.get(i).left = nodeList.get(i - 1);
            nodeList.get(i).right = nodeList.get(i + 1);
        }
        Node last = nodeList.get(nodeList.size() - 1);
        last.right = first;
        last.left = nodeList.get(nodeList.size() - 2);
        first.right = nodeList.get(1);
        first.left = last;
        return first;
    }

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        nodeList.add(node);
        inOrder(node.right);
    }


    Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void dfs(Node node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        if (pre != null) {
            pre.right = node;
        } else {
            head = node;
        }
        node.left = pre;
        pre = node;
        dfs(node.right);
    }
}
