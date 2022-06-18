package com.yore.offer2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yore
 * @date 2022/2/23 15:32
 * @description
 */
public class Offer052 {
    public static Deque<TreeNode> queue = new LinkedList<>();

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4, node3, null);
        TreeNode root = new TreeNode(2, node1, node4);
        System.out.println(increasingBST(root));
    }

    public static TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        TreeNode p = queue.pollFirst();
        TreeNode res = p;
        while (!queue.isEmpty()) {
            TreeNode q = queue.pollFirst();
            p.left = null;
            p.right = q;
            p = q;
        }
        p.left = null;
        p.right = null;
        return res;
    }

    public static void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        queue.offerLast(node);
        inOrder(node.right);
    }


    /**
     * 方法二： 在中序遍历的过程中同时修改结点指针
     */
    private TreeNode resNode;

    public TreeNode increasingBST2(TreeNode root) {
        TreeNode dummyNode = new TreeNode(-1);
        resNode = dummyNode;
        inOrder2(root);
        return dummyNode.right;
    }

    public void inOrder2(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);

        resNode.right = node;
        node.left = null;
        resNode = node;

        inOrder(node.right);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
