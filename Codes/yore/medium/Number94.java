package com.yore.medium;

import com.yore.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author jia bing wen
 * @date 2021/4/16 10:01
 * @description 中序遍历
 */
public class Number94 {

    /**
     * 非递归解法，用栈模拟递归过程
     *
     * @param root
     */
    public List<Integer> inOrderNonRecursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode node = root;
        Stack<TreeNode> st = new Stack<>();
        while (!st.empty() || node != null) {
            while(node!=null){
                st.push(node);
                node = node.left;
            }
            node = st.pop();
            result.add(node.val);
            node = node.right;
        }
        return result;
    }
}
