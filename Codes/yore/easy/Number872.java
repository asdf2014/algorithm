package com.yore.easy;

import com.yore.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jia bing wen
 * @date 2021/5/10 7:50
 * @description
 */
public class Number872 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        preOrder(root1, list1);
        preOrder(root2, list2);

        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if ((int) list1.get(i) != list2.get(i)) {
                return false;
            }
        }

        return true;
    }

    public void preOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            list.add(node.val);
            return;
        }
        preOrder(node.left, list);
        preOrder(node.right, list);
    }
}
