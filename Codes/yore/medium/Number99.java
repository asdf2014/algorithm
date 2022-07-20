package com.yore.medium;

import com.yore.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/6/2 9:49
 * @description
 */
public class Number99 {
    List<Integer> list = new ArrayList<>();

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root);
        int[] pos = findPos();
        exchange(root, pos[0], pos[1]);
    }

    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        list.add(node.val);
        inOrder(node.right);
    }

    public int[] findPos() {
        int index1 = -1;
        int index2 = -1;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                index2 = i + 1;
                if (index1 == -1) {
                    index1 = i;
                } else {
                    break;
                }
            }
        }
        return new int[]{list.get(index1), list.get(index2)};
    }

    public void exchange(TreeNode node, int val1, int val2) {
        if (node == null) {
            return;
        }
        if (node.val == val1 || node.val == val2) {
            node.val = node.val == val1 ? val2 : val1;
        }
        exchange(node.left, val1, val2);
        exchange(node.right, val1, val2);
    }
}
