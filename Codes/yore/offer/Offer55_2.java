package com.yore.offer;

import com.yore.base.TreeNode;

/**
 * @author jia bing wen
 * @date 2021/7/5 9:20
 * @description
 */
public class Offer55_2 {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        if (Math.abs(depth(root.left) - depth(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = depth(node.left) + 1;
        int right = depth(node.right) + 1;
        return Math.max(left, right);
    }
}
