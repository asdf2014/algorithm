package com.yore.easy;

import java.util.Stack;

/**
 * Created on 2019/1/25
 *
 * @author jiabingwen
 */

public class Number965 {
    public static void main(String[] args) {

    }

    public boolean isUnivalTree(TreeNode root) {
        int val = root.val;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (true) {
            while (root != null) {
                if (val != root.val) {
                    return false;
                }
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            root = stack.pop();
            root = root.right;
        }
        return true;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

