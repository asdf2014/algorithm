package com.yore.easy;

import com.yore.base.TreeNode;

/**
 * @author jia bing wen
 * @date 2021/4/28 16:30
 * @description
 */
public class Number104 {
    public int maxDepth(TreeNode root) {
        return getDepth(root);
    }

    public int getDepth(TreeNode root){
        if(root ==null){
            return 0;
        }
        return Math.max(getDepth(root.left)+1,getDepth(root.right)+1);
    }
}
