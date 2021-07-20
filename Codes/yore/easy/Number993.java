package com.yore.easy;

import com.yore.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jia bing wen
 * @date 2021/5/17 7:55
 * @description
 */
public class Number993 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);


        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.right = node5;

        System.out.println(isCousins(node1, 5, 4));
    }

    /**
     * 广度优先
     * @param root
     * @param x
     * @param y
     * @return
     */
    public static boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depthX = 1, depthY = 1;
        TreeNode xFather = null, yFather = null;
        int count = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            count--;
            if (node.left != null) {
                if (node.left.val == x) {
                    xFather = node;
                } else if (node.left.val == y) {
                    yFather = node;
                }
                queue.offer(node.left);
            }
            if (node.right != null) {
                if (node.right.val == x) {
                    xFather = node;
                } else if (node.right.val == y) {
                    yFather = node;
                }
                queue.offer(node.right);
            }
            // count减为0，说明该层遍历完毕，进入下一层
            if (count == 0) {
                count = queue.size();
                if (xFather == null) {
                    depthX++;
                }
                if (yFather == null) {
                    depthY++;
                }
            }
        }

        return xFather != yFather && depthX == depthY;
    }

}
