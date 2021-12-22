package com.yore.medium;

import com.yore.base.TreeNode;

/**
 * @author jia bing wen
 * @date 2021/5/22 9:40
 * @description
 */
public class Number230 {
    int count = 0;
    int value = 0;
    int target;

    public int kthSmallest(TreeNode root, int k) {
        target = k;
        rec(root);
        return value;
    }

    public void rec(TreeNode node) {
        if (node == null) {
            return;
        }
        rec(node.left);
        count++;
        if (count == target) {
            value = node.val;
        }
        rec(node.right);
    }
}
