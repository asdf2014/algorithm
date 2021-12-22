package com.yore.easy;

import com.yore.base.TreeNode;

/**
 * @author jia bing wen
 * @date 2021/4/28 16:31
 * @description
 */
public class Number111 {
    public int minDepth(TreeNode root) {
        return getDepth(root);
    }

    public int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null) {
            return getDepth(node.right) + 1;
        } else if (node.right == null) {
            return getDepth(node.left) + 1;
        } else {
            return Math.min(getDepth(node.left), getDepth(node.right)) + 1;
        }
    }
}
