package com.yore.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/1/13 15:04
 * @description
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class Number589 {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        func(root, res);
        return res;
    }

    public void func(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        for (Node n : node.children) {
            func(n, res);
        }
    }
}
