package com.yore.offer2;

import com.yore.base.TreeNode;

/**
 * @author Yore
 * @date 2022/3/3 10:02
 * @description
 */
public class Offer054 {
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        TreeNode node = root;
        process(node);
        return root;
    }

    public void process(TreeNode node) {
        if (node == null) {
            return;
        }
        process(node.right);
        sum += node.val;
        node.val = sum;
        process(node.left);
    }
}
