package com.yore.medium;

import com.yore.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jia bing wen
 * @date 2021/5/19 10:26
 * @description
 */
public class Number113 {
    List<List<Integer>> result = new ArrayList<>();
    int target;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        List<Integer> list = new ArrayList<>();
        dfs(root, 0, list);
        return result;
    }

    public void dfs(TreeNode node, int sum, List<Integer> list) {
        if (node == null) {
            return;
        }
        sum += node.val;
        list.add(node.val);
        if (sum == target && node.left == null && node.right == null) {
            result.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        dfs(node.left, sum, list);
        dfs(node.right, sum, list);
        if (list.size() > 0) {
            list.remove(list.size() - 1);
        }
    }
}
