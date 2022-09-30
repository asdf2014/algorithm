package com.yore.easy;

import com.yore.base.TreeNode;

/**
 * @author Yore
 * @date 2022/6/15 9:55
 * @description
 */
public class Number543 {
    int max;

    public int diameterOfBinaryTree(TreeNode root) {
        max = 1;
        dfs(root);
        return max - 1;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        max = Math.max(left + right + 1, max);
        return Math.max(left, right) + 1;
    }
}
