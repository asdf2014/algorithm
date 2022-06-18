package com.yore.medium;

import com.yore.base.TreeNode;

/**
 * @author Yore
 * @date 2022/3/3 9:41
 * @description
 */
public class Number285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode after = null;
        while (root != null) {
            if (root.val > p.val) {
                after = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return after;
    }
}
