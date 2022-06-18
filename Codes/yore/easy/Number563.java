package com.yore.easy;

import com.yore.base.TreeNode;

/**
 * @author Yore
 * @date 2021/11/18 9:06
 * @description
 */
public class Number563 {
    private int sum = 0;
    public int findTilt(TreeNode root) {
        subTreeSum(root);
        return sum;
    }

    public int subTreeSum(TreeNode node){
        if(node == null){
            return 0 ;
        }
        int left = subTreeSum(node.left);
        int right = subTreeSum(node.right);
        sum += Math.abs(left-right);
        return node.val+left+right;
    }
}
