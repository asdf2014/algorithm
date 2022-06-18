package com.yore.offer2;

import com.yore.base.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/3/1 11:09
 * @description
 */
public class Offer044 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return result;
        }
        queue.offerLast(root);
        int count;
        while (!queue.isEmpty()) {
            count = queue.size();
            int maxValue = Integer.MIN_VALUE;
            while (count > 0) {
                TreeNode node = queue.pollFirst();
                count--;
                if (node.left != null) {
                    queue.offerLast(node.left);
                }
                if (node.right != null) {
                    queue.offerLast(node.right);
                }
                maxValue = Math.max(maxValue, node.val);
            }
            result.add(maxValue);
        }
        return result;
    }
}
