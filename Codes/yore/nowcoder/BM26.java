package com.yore.nowcoder;

import com.yore.base.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yore
 * @date 2022/5/9 10:15
 * @description  二叉树层序遍历
 */
public class BM26 {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        int count = 0;
        while (!queue.isEmpty()) {
            count = queue.size();
            ArrayList<Integer> list = new ArrayList();
            while (count > 0) {
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
            res.add(list);
        }
        return res;
    }
}
