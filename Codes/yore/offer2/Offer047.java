package com.yore.offer2;

import com.yore.base.TreeNode;

/**
 * @author Yore
 * @date 2022/3/1 14:59
 * @description
 */
public class Offer047 {
    public TreeNode pruneTree(TreeNode root) {
        TreeNode node = root;
        return process(root) ? null : node;
    }

    public boolean process(TreeNode node) {
        if (node == null) {
            return true;
        }
        boolean left = process(node.left);
        boolean right = process(node.right);
        if (node.val == 0 && left && right) {
            node = null;
            return true;
        }
        if (left) {
            node.left = null;
        }
        if (right) {
            node.right = null;
        }
        return false;
    }
}
