package com.yore.medium;

import com.yore.base.TreeNode;

/**
 * @author jia bing wen
 * @date 2021/5/22 10:25
 * @description
 */
public class Number538 {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        rec(root);
        return root;
    }

    public void rec(TreeNode node) {
        if (node == null) {
            return;
        }
        rec(node.right);
        sum += node.val;
        node.val = sum;
        rec(node.left);
    }

}
