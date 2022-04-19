package com.yore.offer;

import com.yore.base.TreeNode;

/**
 * @author jia bing wen
 * @date 2021/6/24 14:27
 * @description
 */
public class Offer26 {
    TreeNode node2;
    boolean flag;

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }

        this.node2 = B;
        preOrder(A);
        return flag;
    }

    public void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        if (isSimilar(node, node2)) {
            flag = true;
            return;
        }
        preOrder(node.left);
        preOrder(node.right);
    }


    public boolean isSimilar(TreeNode node1, TreeNode node2) {
        if (node2 == null) {
            return true;
        }
        if (node1 == null) {
            return false;
        }
        if (node1.val == node2.val) {
            return isSimilar(node1.left, node2.left) && isSimilar(node1.right, node2.right);
        }
        return false;
    }

}
