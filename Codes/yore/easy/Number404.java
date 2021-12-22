package com.yore.easy;

import com.yore.base.TreeNode;

/**
 * @author jia bing wen
 * @date 2021/5/21 9:20
 * @description
 */
public class Number404 {
    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        rec(root, 0);
        return sum;
    }

    public void rec(TreeNode node, int flag) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null && flag == 1) {
            sum += node.val;
        }
        rec(node.left, 1);
        rec(node.right, 0);
    }
}
