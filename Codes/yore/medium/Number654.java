package com.yore.medium;

import com.yore.base.TreeNode;

/**
 * @author jia bing wen
 * @date 2021/5/18 9:17
 * @description
 */
public class Number654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return rec(nums, 0, nums.length - 1);
    }

    public TreeNode rec(int[] nums, int begin, int end) {
        if (begin > end) {
            return null;
        }
        int max = -1;
        int index = 0;
        for (int i = begin; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode left = rec(nums, begin, index-1);
        TreeNode right = rec(nums, index + 1, end);
        TreeNode root = new TreeNode(max);
        root.left = left;
        root.right = right;
        return root;
    }
}
