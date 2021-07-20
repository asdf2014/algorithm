package com.yore.medium;

import com.yore.base.TreeNode;

/**
 * @author jia bing wen
 * @date 2021/5/20 15:25
 * @description
 */
public class Number129 {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        rec(root, 0);
        return sum;
    }

    public void rec(TreeNode node, int num) {
        num += node.val;
        if (node.left == null && node.right == null) {
            sum += num;
            return;
        }
        if (node.left != null) {
            rec(node.left, num * 10);
        }
        if (node.right != null) {
            rec(node.right, num * 10);
        }
    }
}
