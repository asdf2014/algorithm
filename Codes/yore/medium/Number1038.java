package com.yore.medium;

import com.yore.base.TreeNode;

/**
 * @author Yore
 * @date 2021/11/16 10:49
 * @description
 */
public class Number1038 {
    private int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        traverse(root);
        return root;
    }

    public void traverse(TreeNode node){
        if(node == null){
            return;
        }
        traverse(node.right);
        sum += node.val;
        node.val = sum;
        traverse(node.left);
        return;
    }
}
