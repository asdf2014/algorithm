package com.yore.offer;

import com.yore.base.TreeNode;

/**
 * @author jia bing wen
 * @date 2021/6/9 9:16
 * @description
 */
public class Offer27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = mirrorTree(root.right);
        TreeNode right = mirrorTree(root.left);

        root.left = left;
        root.right = right;
        return root;
    }
}
