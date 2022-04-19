package com.yore.offer2;

import com.yore.base.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/3/1 14:39
 * @description
 */
public class Offer046 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        int count = queue.size();
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            count--;
            if (node.left != null) {
                queue.offerLast(node.left);
            }
            if (node.right != null) {
                queue.offerLast(node.right);
            }
            if (count == 0) {
                count = queue.size();
                result.add(node.val);
            }
        }
        return result;
    }
}
