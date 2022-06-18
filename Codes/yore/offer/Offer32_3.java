package com.yore.offer;

import com.yore.base.TreeNode;

import java.util.*;

/**
 * @author jia bing wen
 * @date 2021/6/24 8:52
 * @description
 */
public class Offer32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        boolean reverse = false;
        int count = 0;
        Stack<Integer> st = new Stack<>();

        while (!queue.isEmpty()) {
            if (reverse) {
                count = queue.size();
                st = new Stack<>();
                while (count > 0) {
                    TreeNode node = queue.pollFirst();
                    st.push(node.val);
                    if (node.left != null) {
                        queue.offerLast(node.left);
                    }
                    if (node.right != null) {
                        queue.offerLast(node.right);
                    }
                    count--;
                }
                List<Integer> list = new ArrayList<>();
                while (!st.isEmpty()) {
                    list.add(st.pop());
                }
                result.add(list);
                reverse = false;
            } else {
                count = queue.size();
                List<Integer> list = new ArrayList<>();
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
                result.add(list);
                reverse = true;
            }
        }
        return result;
    }
}
