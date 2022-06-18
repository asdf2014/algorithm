package com.yore.medium;

import com.yore.base.TreeNode;

import java.util.*;

/**
 * @author Yore
 * @date 2022/4/24 9:36
 * @description
 */
public class Number103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return result;
        }
        int level = 0;
        int count = 1;
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            while (count != 0) {
                TreeNode node = queue.pollFirst();
                list.add(node.val);
                if (node.left != null) {
                    queue.offerLast(node.left);
                }
                if (node.right != null) {
                    queue.offerLast(node.right);
                }
                count--;
            }
            if (level % 2 != 0) {
                Collections.reverse(list);
            }
            result.add(list);
            count = queue.size();
            level++;
        }
        return result;
    }
}
