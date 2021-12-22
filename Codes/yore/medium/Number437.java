package com.yore.medium;

import com.yore.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jia bing wen
 * @date 2021/5/21 9:52
 * @description
 */
public class Number437 {
    int target;
    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        rec(root, 0);
        return count;
    }

    public void rec(TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        sum += node.val;
        if (sum == target) {
            count++;
        }
        rec(node.left, sum);
        rec(node.right, sum);
        rec(node.left, 0);
        rec(node.right, 0);
    }

    public static void main(String[] args) {
        Number437 number = new Number437();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.right = node2;
        node2.right = node3;
        node3.right = node4;
        node4.right = node5;

        System.out.println(number.pathSum(node1, 3));
    }
}
