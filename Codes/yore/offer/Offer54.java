package com.yore.offer;

import com.yore.base.TreeNode;

import java.util.Stack;

/**
 * @author jia bing wen
 * @date 2021/7/2 10:54
 * @description
 */
public class Offer54 {

    private int result = 0;
    private int k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        inOrderReverse(root);
        return result;
    }

    public void inOrderReverse(TreeNode node) {
        if (node == null || k == 0) {
            return;
        }
        inOrderReverse(node.right);
        if (--k == 0) {
            result = node.val;
            return;
        }
        inOrderReverse(node.left);
    }
}
