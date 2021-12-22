package com.yore.easy;

import com.yore.base.TreeNode;

/**
 * @author jia bing wen
 * @date 2021/5/24 9:03
 * @description
 */
public class Number572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        return isSame(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }


    public boolean isSame(TreeNode node, TreeNode sub) {
        if (node == null && sub == null) {
            return true;
        }
        if (node == null || sub == null || node.val != sub.val) {
            return false;
        }
        return isSame(node.left, sub.left) && isSame(node.right, sub.right);
    }
}
