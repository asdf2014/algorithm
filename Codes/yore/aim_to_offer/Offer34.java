package com.yore.offer;

import com.yore.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jia bing wen
 * @date 2021/6/27 15:19
 * @description
 */
public class Offer34 {
    private int target;
    private List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return new ArrayList<>();
        }
        this.target = target;
        this.result = new ArrayList<>();
        dfs(root, new ArrayList<>(), 0);
        return result;
    }

    public void dfs(TreeNode node, List<Integer> list, int sum) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        sum += node.val;
        if (sum == target && node.left == null && node.right == null) {
            result.add(new ArrayList<>(list));
        }
        dfs(node.left, list, sum);
        dfs(node.right, list, sum);
        list.remove(list.size() - 1);
    }
}
