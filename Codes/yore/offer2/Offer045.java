package com.yore.offer2;

import com.yore.base.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yore
 * @date 2022/3/1 14:34
 * @description
 */
public class Offer045 {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        int result = root.val;
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count > 0) {
                TreeNode node = queue.pollFirst();
                if (node.left != null) {
                    queue.offerLast(node.left);
                }
                if (node.right != null) {
                    queue.offerLast(node.right);
                }
                count--;
            }
            if (!queue.isEmpty()) {
                result = queue.peekFirst().val;
            }
        }
        return result;
    }
}
