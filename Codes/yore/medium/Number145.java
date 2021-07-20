package com.yore.medium;

import com.yore.base.TreeNode;

import java.util.*;

/**
 * @author jia bing wen
 * @date 2021/4/15 9:08
 * @description 后序遍历
 */
public class Number145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrderRecursion(root, list);
        return list;
    }

    /**
     * 递归解法
     *
     * @param node
     * @param list
     */
    public void postOrderRecursion(TreeNode node, List<Integer> list) {
        if (node != null) {
            postOrderRecursion(node.left, list);
            postOrderRecursion(node.right, list);
            list.add(node.val);
        }
    }

    /**
     * 非递归解法，采用栈
     *
     * @param root
     */
    public List<Integer> postOrderNonRecursion(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> res = new ArrayList<Integer>();
        TreeNode node = root;
        TreeNode prev = null;
        while (!st.empty() || node != null) {
            while (node != null) {
                st.push(node);
                node = node.left;
            }
            node = st.pop();
            if (node.right == null || node.right == prev) {
                res.add(node.val);
                prev = node;
                node = null;
            } else {
                st.push(node);
                node = node.right;
            }
        }
        return res;
    }
}
