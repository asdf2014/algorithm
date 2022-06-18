package com.yore.nowcoder;

import com.yore.base.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/5/5 14:52
 * @description 二叉树前序遍历
 */
public class BM23 {
    List<Integer> list = new ArrayList<>();

    public int[] preorderTraversal(TreeNode root) {
        preOrder(root);
        return list.stream().mapToInt(Integer::new).toArray();
    }

    public void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 迭代遍历
     *
     * @param root
     * @return
     */
    public int[] preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode node = root;
        Deque<TreeNode> queue = new LinkedList<>();
        while (!queue.isEmpty() || node != null) {
            while (node != null) {
                queue.offerLast(node);
                list.add(node.val);
                node = node.left;
            }
            node = queue.pollLast();
            node = node.right;
        }
        return list.stream().mapToInt(Integer::new).toArray();
    }
}
