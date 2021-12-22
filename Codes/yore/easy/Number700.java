package com.yore.easy;

import com.yore.base.TreeNode;

/**
 * @author jia bing wen
 * @date 2021/5/24 8:57
 * @description
 */
public class Number700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }
}
