package com.yore.nowcoder;

import com.yore.base.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/5/9 9:43
 * @description 二叉树中序遍历
 */
public class BM24 {

    List<Integer> list = new ArrayList<>();

    public int[] inorderTraversal(TreeNode root) {
        inOrder(root);
        return list.stream().mapToInt(Integer::new).toArray();
    }

    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        list.add(node.val);
        inOrder(node.right);
    }

    /**
     * 迭代遍历
     *
     * @param root
     * @return
     */
    public int[] inorderTraversal2(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode node = root;
        while (!queue.isEmpty() || node != null) {
            while (node != null) {
                queue.offerLast(node);
                node = node.left;
            }
            node = queue.pollLast();
            list.add(node.val);
            node = node.right;
        }
        return list.stream().mapToInt(Integer::new).toArray();
    }
}
