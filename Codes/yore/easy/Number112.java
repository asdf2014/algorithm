package com.yore.easy;

import com.yore.base.TreeNode;

/**
 * @author jia bing wen
 * @date 2021/5/19 10:07
 * @description
 */
public class Number112 {
    int target;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        target = targetSum;
        return dfs(root, 0);
    }

    public boolean dfs(TreeNode node, int sum) {
        if (node == null) {
            return false;
        }
        sum += node.val;
        if (sum == target && node.left == null && node.right == null) {
            return true;
        }
        if (dfs(node.left, sum)) {
            return true;
        }
        return dfs(node.right, sum);
    }
}
