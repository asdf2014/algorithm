package com.yore.offer2;

import com.yore.base.TreeNode;

/**
 * @author Yore
 * @date 2022/3/2 10:03
 * @description
 */
public class Offer050 {
    private int target;
    private int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        this.target = targetSum;
        preProcess(root, 0);
        if (root != null) {
            pathSum(root.left, targetSum);
            pathSum(root.right, targetSum);
        }
        return count;
    }

    public void preProcess(TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        sum += node.val;
        if (sum == target) {
            count++;
        }
        preProcess(node.left, sum);
        preProcess(node.right, sum);
    }
}
