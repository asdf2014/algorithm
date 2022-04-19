package com.yore.offer2;

import com.yore.base.TreeNode;

/**
 * @author Yore
 * @date 2022/3/2 10:46
 * @description
 */
public class Offer051 {
    private int ret = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ret;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));
        ret = Math.max(ret, node.val + left + right);
        return node.val + Math.max(left, right);
    }
}
