package com.yore.medium;

import com.yore.base.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Yore
 * @date 2022/5/1 18:34
 * @description
 */
public class Number1305 {
    List<Integer> list = new ArrayList<>();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        inOrder(root1);
        inOrder(root2);
        Collections.sort(list);
        return list;
    }

    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        list.add(node.val);
        inOrder(node.right);
    }
}
