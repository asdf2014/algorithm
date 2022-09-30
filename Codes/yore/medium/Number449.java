package com.yore.medium;

import com.yore.base.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yore
 * @date 2022/5/11 11:16
 * @description
 */
public class Number449 {

    public static void main(String[] args) {
        Number449 number449 = new Number449();

    }


    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder("");
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            if (node != null) {
                sb.append(node.val).append(",");
                queue.offerLast(node.left);
                queue.offerLast(node.right);
            } else {
                sb.append("null,");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] vals = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        int idx = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            if (!"null".equals(vals[idx])) {
                node.left = new TreeNode(Integer.parseInt(vals[idx]));
                queue.offerLast(node.left);
            }
            idx++;
            if (!"null".equals(vals[idx])) {
                node.right = new TreeNode(Integer.parseInt(vals[idx]));
                queue.offerLast(node.right);
            }
            idx++;
        }
        return root;
    }
}
