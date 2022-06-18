package com.yore.medium;

import com.yore.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/4/25 9:17
 * @description
 */
public class Number1382 {
    List<Integer> list = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        inOrder(root);
        return helper(list, 0, list.size() - 1);
    }

    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        list.add(node.val);
        inOrder(node.right);
    }

    public TreeNode helper(List<Integer> list, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = helper(list, left, mid - 1);
        node.right = helper(list, mid + 1, right);
        return node;
    }
}
