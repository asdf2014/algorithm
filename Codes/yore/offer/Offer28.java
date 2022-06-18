package com.yore.offer;

import com.yore.base.TreeNode;

/**
 * @author jia bing wen
 * @date 2021/6/22 8:29
 * @description
 */
public class Offer28 {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left != null && right != null && left.val == right.val) {
            return check(left.right, right.left) && check(left.left, right.right);
        }
        return false;
    }
}
