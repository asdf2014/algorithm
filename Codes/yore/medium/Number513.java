package com.yore.medium;

import com.yore.base.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yore
 * @date 2022/6/22 8:57
 * @description
 */
public class Number513 {
    public int findBottomLeftValue(TreeNode root) {
        int res = root.val;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            int idx = 0;
            while (count > 0) {
                TreeNode node = queue.pollFirst();
                if (idx == 0) {
                    res = node.val;
                }
                if (node.left != null) {
                    queue.offerLast(node.left);
                }
                if (node.right != null) {
                    queue.offerLast(node.right);
                }
                count--;
                idx++;
            }
        }
        return res;
    }
}
