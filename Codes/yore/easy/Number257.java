package com.yore.easy;

import com.yore.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jia bing wen
 * @date 2021/5/20 15:58
 * @description
 */
public class Number257 {
    List<String> list = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return list;
        }
        String route = "";
        rec(root, route);
        return list;
    }

    public void rec(TreeNode node, String route) {
        if (route.length() > 0) {
            route += "->";
        }
        route += node.val;
        if (node.left == null && node.right == null) {
            list.add(route);
            return;
        }
        rec(node.left, route);
        rec(node.right, route);
    }
}
