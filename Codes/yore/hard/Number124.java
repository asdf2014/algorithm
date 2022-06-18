package com.yore.hard;

import com.yore.base.TreeNode;

/**
 * @author jia bing wen
 * @date 2021/5/19 10:48
 * @description
 */
public class Number124 {
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return ans;
    }

    public int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int val = node.val;
        int left = Math.max(helper(node.left), 0);
        int right = Math.max(helper(node.right), 0);
        ans = Math.max(ans, left + right + val);
        return Math.max(left, right) + val;
    }
}
