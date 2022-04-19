package com.yore.offer;

import com.yore.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jia bing wen
 * @date 2021/7/13 9:04
 * @description
 */
public class Offer37 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("null ");
            } else {
                sb.append(node.val).append(" ");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    private int length;
    private String[] datas;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        data = data.trim();
        this.datas = data.split(" ");
        this.length = datas.length;
        if (length <= 0) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(datas[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i =1;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(!datas[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(datas[i]));
                queue.add(node.left);
            }
            i++;
            if(!datas[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(datas[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }


    public static void main(String[] args) {
        String data = "1 2 null 3 null 4 null 5 null null null";
        Offer37 o = new Offer37();
        o.deserialize(data);
    }
}
