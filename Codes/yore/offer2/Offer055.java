package com.yore.offer2;

import com.yore.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/3/3 10:23
 * @description
 */
public class Offer055 {
    public int index;
    public List<Integer> inOrderList;

    public Offer055(TreeNode root) {
        inOrderList = new ArrayList<>();
        inOrder(root);
        index = 0;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        inOrderList.add(node.val);
        inOrder(node.right);
    }

    public int next() {
        return inOrderList.get(index++);
    }

    public boolean hasNext() {
        return index < inOrderList.size();
    }
}
