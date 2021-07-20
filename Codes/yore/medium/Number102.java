package com.yore.medium;

import com.yore.base.TreeNode;

import java.util.*;

/**
 * @author jia bing wen
 * @date 2021/4/26 9:30
 * @description
 */
public class Number102 {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        TreeNode node = root;
        nodeQueue.offer(node);
        int count = 0;
        List<List<Integer>> result = new ArrayList<>();
        while (!nodeQueue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            count = nodeQueue.size();
            while (count > 0) {
                node = nodeQueue.poll();
                list.add(node.val);
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                }
                count--;
            }
            result.add(list);
        }
        return result;
    }
}
