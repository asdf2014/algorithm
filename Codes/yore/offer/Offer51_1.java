package com.yore.offer;

import com.yore.base.TreeNode;

/**
 * @author jia bing wen
 * @date 2021/6/21 8:15
 * @description
 */
public class Offer51_1 {
    public int maxDepth(TreeNode root) {
        return getDepth(root);
    }

    public int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
    }

}
