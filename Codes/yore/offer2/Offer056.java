package com.yore.offer2;

import com.yore.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/3/3 10:37
 * @description
 */
public class Offer056 {
    public List<Integer> list;

    public boolean findTarget(TreeNode root, int k) {
        list = new ArrayList<>();
        inOrder(root, k);
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            int sum = list.get(l) + list.get(r);
            if (sum == k) {
                return true;
            } else if (sum > k) {
                r--;
            } else {
                l++;
            }
        }
        return false;
    }

    public void inOrder(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        inOrder(node.left, k);
        list.add(node.val);
        inOrder(node.right, k);
    }
}
