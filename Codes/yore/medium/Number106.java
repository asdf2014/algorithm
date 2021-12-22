package com.yore.medium;

import com.yore.base.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jia bing wen
 * @date 2021/5/7 8:27
 * @description 根据中序遍历和后序遍历构造二叉树
 */
public class Number106 {
    int postIndex;
    int[] inOrder;
    int[] postOrder;
    Map<Integer, Integer> idxMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inOrder = inorder;
        this.postOrder = postorder;
        postIndex = postOrder.length - 1;
        int idx = 0;
        for (Integer val : inOrder) {
            idxMap.put(val, idx++);
        }
        return createTree(0, inOrder.length - 1);
    }

    public TreeNode createTree(int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }
        int rootVal = postOrder[postIndex];
        TreeNode node = new TreeNode(rootVal);
        int index = idxMap.get(rootVal);
        postIndex--;
        node.right = createTree(index + 1, inRight);
        node.left = createTree(inLeft, index - 1);
        return node;
    }
}
