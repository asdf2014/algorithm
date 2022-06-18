package com.yore.offer;

import com.yore.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jia bing wen
 * @date 2021/5/29 8:53
 * @description
 */
public class Offer07 {
    int[] pre;
    int index = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        pre = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return create(0, inorder.length - 1);
    }


    public TreeNode create(int begin, int end) {
        if (begin > end) {
            return null;
        }
        int value = pre[index];
        TreeNode node = new TreeNode(value);
        index++;
        node.left = create(begin, map.get(value) - 1);
        node.right = create(map.get(value) + 1, end);
        return node;
    }

    public static void main(String[] args) {
        Offer07 offer07 = new Offer07();
        System.out.println(offer07.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }
}
