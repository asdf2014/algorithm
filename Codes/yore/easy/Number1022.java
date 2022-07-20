package com.yore.easy;

import com.yore.base.TreeNode;

/**
 * @author Yore
 * @date 2022/5/30 8:49
 * @description
 */
public class Number1022 {
    private int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return sum;
        }
        StringBuilder sb = new StringBuilder("");
        sb.append(root.val);
        dfs(root, sb);
        return sum;
    }

    public void dfs(TreeNode node, StringBuilder sb) {
        if (node.left == null && node.right == null) {
            sum += convert(sb.toString());
            return;
        }
        if (node.left != null) {
            sb.append(node.left.val);
            dfs(node.left, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (node.right != null) {
            sb.append(node.right.val);
            dfs(node.right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private int convert(String s) {
        int n = 0;
        int p = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            n += (s.charAt(i) - '0') * Math.pow(2, p++);
        }
        return n;
    }
}
