package com.yore.medium;

import com.yore.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author jia bing wen
 * @date 2021/4/16 10:01
 * @description 二叉树的前序遍历
 */
public class Number144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    /**
     * 递归解法
     *
     * @param node
     * @param list
     */
    public void preOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        preOrder(node.left, list);
        preOrder(node.right, list);
    }

    /**
     * 非递归解法，用栈模拟递归过程
     *
     * @param root
     */
    public List<Integer> preOrderNonRecursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode node = root;
        Stack<TreeNode> st = new Stack<>();
        while (!st.empty() || node != null) {
            while(node!=null){
                st.push(node);
                result.add(node.val);
                node = node.left;
            }
            node = st.pop();
            node = node.right;
        }
        return result;
    }
}
