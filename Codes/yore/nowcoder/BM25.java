package com.yore.nowcoder;

import com.yore.base.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/5/9 10:00
 * @description 二叉树后序遍历
 */
public class BM25 {
    List<Integer> list = new ArrayList<>();

    public int[] postorderTraversal(TreeNode root) {
        postOrder(root);
        return list.stream().mapToInt(Integer::new).toArray();
    }

    public void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        list.add(node.val);
    }

    /**
     * 迭代后序遍历
     *
     * @param root
     * @return
     */
    public int[] postorderTraversal2(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode node = root;
        TreeNode pre = null;
        while (!queue.isEmpty() || node != null) {
            while (node != null) {
                queue.offerLast(node);
                node = node.left;
            }
            node = queue.pollLast();
            if (node.right == null || node.right == pre) {
                list.add(node.val);
                pre = node;
                node = null;
            } else {
                queue.offerLast(node);
                node = node.right;
            }
        }
        return list.stream().mapToInt(Integer::new).toArray();
    }

}
