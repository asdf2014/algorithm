package com.yore.medium;

import com.yore.base.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/6/24 8:43
 * @description
 */
public class Number515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        int count = 0;
        while (!queue.isEmpty()) {
            count = queue.size();
            int max = Integer.MIN_VALUE;
            while (count > 0) {
                TreeNode node = queue.pollFirst();
                max = Math.max(max, node.val);
                if (node.left != null) {
                    queue.offerLast(node.left);
                }
                if (node.right != null) {
                    queue.offerLast(node.right);
                }
                count--;
            }
            list.add(max);
        }
        return list;
    }
}
