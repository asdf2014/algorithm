package com.yore.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/1/13 15:07
 * @description
 */

public class Number590 {
    public List<Integer> postorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        func(root, res);
        return res;
    }

    public void func(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }
        for (Node n : node.children) {
            func(n, res);
        }
        res.add(node.val);
    }
}

