package com.yore.offer2;

import com.yore.base.TreeNode;

/**
 * @author Yore
 * @date 2022/3/2 9:35
 * @description
 */
public class Offer049 {
    public int sum = 0;

    public int sumNumbers(TreeNode root) {
        preIter(root, 0);
        return sum;
    }

    public TreeNode preIter(TreeNode node, int num) {
        if (node == null) {
            return null;
        }
        num = (num * 10 + node.val);
        TreeNode left = preIter(node.left, num);
        TreeNode right = preIter(node.right, num);
        if (left == null && right == null) {
            sum += num;
        }
        return node;
    }
}
